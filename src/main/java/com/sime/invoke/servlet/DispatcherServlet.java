package com.sime.invoke.servlet;

import com.sime.invoke.annaotation.*;
import com.sime.invoke.controller.SelfMvcController;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DispatcherServlet extends HttpServlet {

    //存放所有的字节码文件名称
    List<String> classNames = new ArrayList<String>();
    //定义IOC容器，其实就是一个map
    Map<String,Object> beanMap =  new HashMap<String,Object>();
    //存放方法级别的map
    Map<String,Object> handlMap =  new HashMap<String,Object>();


    public void init(ServletConfig config){
        //1、把所有的bean扫描，扫描所有的class文件
        scanPackage("com.sime");
        //2、创建类,根据扫描的全类名，创建类，进行实例化
        doInstance();
        //3、根据bean进行依赖注入
        doIOC();
        //4、建立映射关系
        buildUrlMapping();
    }

    private void buildUrlMapping() {
        if (beanMap.entrySet().size()<=0){
            System.out.println("没有一个实例化的类");
            return;
        }
        for (Map.Entry<String,Object> entry:beanMap.entrySet()) {
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();
            //判断是否为控制类
            if (clazz.isAnnotationPresent(FanController.class)){
                //拿控制类的RequestMapping
                FanRequestMapping annotation = clazz.getAnnotation(FanRequestMapping.class);
                String controllerMapping = annotation.value();
                //获取当前类的所有方法
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method:methods) {
                    if (method.isAnnotationPresent(FanRequestMapping.class)){
                        FanRequestMapping methodAnnotation = method.getAnnotation(FanRequestMapping.class);
                        String methodMapping = methodAnnotation.value();
                        //将下面的映射与方法建立一个映射关系，使用map来保存
                        handlMap.put(controllerMapping+methodMapping,method);
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
    }

    //把Service注入到Controller
    private void doIOC() {
        if (beanMap.entrySet().size()<=0){
            System.out.println("没有一个实例化的类");
            return;
        }
        //把map里面的所有的实例化遍历出来
        for (Map.Entry<String,Object> entry:beanMap.entrySet()) {
            //先拿类
            Object instance = entry.getValue();
            //实例化
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(FanController.class)){
                //判断当前类是否是控制类，只有控制类里才有注入
                //拿到所有属性
                Field[] fields = clazz.getDeclaredFields();
                //遍历所有的变量，看哪些使用到了注解
                for (Field field: fields) {
                    //判断当前属性值上面有没有FanAutowired注解
                    if (field.isAnnotationPresent(FanAutowired.class)){
                        FanAutowired autowired = field.getAnnotation(FanAutowired.class);
                        //拿到Controller中注入的service的名称
                        String value = autowired.value();
                        //暴力反射，privat也可以设置值
                        field.setAccessible(true);
                        //参数一：当前成员变量要放到哪个实例中
                        //参数二：注入到成员属性的bean从map里面获取
                        try {
                            field.set(instance,beanMap.get(value));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
    }


    private void doInstance() {
        if(classNames.size()<=0){
            System.out.println("包扫描失败。。。。。。");
            return;
        }
        //对list里的类进行遍历，然后实例化
        for (String className:classNames) {
            String cn = className.replace(".class", "");
            try {
                Class<?> clazz = Class.forName(cn);
                //判断当前类的声明，是否是FanController
                if (clazz.isAnnotationPresent(FanController.class)){
                    Object instance = clazz.newInstance();//控制类实例化对象
                    //拿注解
                    FanRequestMapping requestMapping = clazz.getAnnotation(FanRequestMapping.class);
                    //拿路由 获取到 /fan
                    String rmvalue = requestMapping.value();
                    beanMap.put(rmvalue,instance);
                } else if (clazz.isAnnotationPresent(FanService.class)){
                    //拿service上的注解
                    FanService annotation = clazz.getAnnotation(FanService.class);
                    String serviceValue = annotation.value();
                    beanMap.put(serviceValue,clazz.newInstance());
                } else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void scanPackage(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        String urlFile = url.getFile();
        File file = new File(urlFile);
        String[] list = file.list();
        for (String path:list) {
            File pathFile = new File(path);
            if(pathFile.isDirectory()){
                scanPackage(basePackage+"."+path);
            }else {
                classNames.add(basePackage+"."+pathFile.getName());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //servlet不管任何路径，都会转到servlet来处理，doPost拿到路径，然后调用方法
        //获取请求路径 /fan/query   需要看是否有contextPath
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = requestURI.replace(contextPath, "");
        //根据路径映射拿到方法
        Method method = (Method) handlMap.get(path);
        //根据key=/fan去map里面拿
        SelfMvcController instance = (SelfMvcController) beanMap.get("/" + path.split("/")[1]);
        Object[] arg = hand(req, resp, method);
        try {
            method.invoke(instance,arg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //对request参数与method做处理
    public static Object[] hand(HttpServletRequest request,HttpServletResponse response,Method method){
        //拿到当前待执行的方法有哪些参数
        Class<?>[] paramClazzs = method.getParameterTypes();
        //根据参数的个数，new一个参数的数组，将方法里的所有参数赋值到args里
        Object[] args = new Object[paramClazzs.length];
        int args_i = 0;
        int index = 0;
        for (Class<?> paramClazz : paramClazzs) {
            if (ServletRequest.class.isAssignableFrom(paramClazz)){
                args[args_i++] = request;
            }
            if (ServletResponse.class.isAssignableFrom(paramClazz)){
                args[args_i++] = response;
            }
            //从0-3判断有没有RequestParam注解，很明显ParamClazz为0和1时，不是
            //当2和3时为@RequestParam,需要解析
            Annotation[] paramAns = method.getParameterAnnotations()[index];
            if (paramAns.length>0){
                for (Annotation paramAn:paramAns) {
                    if (FanRequestParam.class.isAssignableFrom(paramAn.getClass())){
                        FanRequestParam requestParam = (FanRequestParam) paramAn;
                        //找到注解里的name和age
                        args[args_i++] = request.getParameter(requestParam.value());
                    }
                }
            }
            index++;
        }
        return args;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }


}

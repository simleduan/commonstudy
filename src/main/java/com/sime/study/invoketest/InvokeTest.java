package com.sime.study.invoketest;

import com.sime.invoke.InvokeMeTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class InvokeTest {

    public static void main(String[] args) {
        Person a =  new Person();
        Person b =  new Person();
        System.out.println(a==(a=b));
    }

    @Test
    public void one(){
        InvokeMeTest meTest = new InvokeMeTest();
        String s = meTest.methodPublic();
        System.out.println(s);
    }

    @Test
    public void one3(){
        try {
            Class<?> invokestyd = Class.forName("com.sime.invoke.InvokeMeTest");
            Method[] methods = invokestyd.getMethods();
            Method[] declaredMethods = invokestyd.getDeclaredMethods();
            Field[] declaredFields = invokestyd.getDeclaredFields();
            try {
                Method method = invokestyd.getMethod("declaredMethods");
                try {
                    Object invoke = method.invoke(null);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

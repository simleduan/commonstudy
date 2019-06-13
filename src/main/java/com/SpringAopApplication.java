package com;


import com.sime.aop.services.AopTest;
import com.sime.aop.services.AopTestImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("com.sime.*")
public class SpringAopApplication {
	
	public static void main(String[] args) {
//		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
//		AopTest aopTest = (AopTest) run.getBean(AopTest.class);
//		aopTest.getAopInfo();

		ConfigurableApplicationContext run1 = SpringApplication.run(Application.class, args);
		AopTestImpl aopTest1 = (AopTestImpl) run1.getBean("aopTest");
		aopTest1.getAopInfo();
		//下面的代码类似：ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		AopTestImpl aopTest = (AopTestImpl) context.getBean("aopTest");


	}
	
}

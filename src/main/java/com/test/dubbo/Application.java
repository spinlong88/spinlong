package com.test.dubbo;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args){
		
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml").start();
		Main.main(args);
		
	}
	

}

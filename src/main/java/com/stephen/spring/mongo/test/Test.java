package com.stephen.spring.mongo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        Calculator addCal = (Calculator) ctx.getBean("addCalculator");
        Calculator subCal = (Calculator) ctx.getBean("subCalculator");

        System.out.println(addCal.getResult(3, 1));
        System.out.println(subCal.getResult(3, 1));

	}

}

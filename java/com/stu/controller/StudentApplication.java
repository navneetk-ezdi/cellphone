package com.stu.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class StudentApplication {
	
	public static void main(String args[]){
		ApplicationContext ac = SpringApplication.run(StudentApplication.class);
		String beans[] = ac.getBeanDefinitionNames();
		if(beans!= null){
			for(int i=0; i<beans.length; i++){
				System.out.println(ac.getBean(beans[i]).getClass().getCanonicalName());
			}
		}
	}
	
}

package com.spring.Demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.Demo.Employee;

public class TestEmployee {
	
	public static void main(String[] args) {
		//Using Bean Factory
		Resource resource=new ClassPathResource("beans.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  
	    Employee employee1 = (Employee)factory.getBean("employeeBean");
	    System.out.println(employee1.getEmployeeName());
	    
	    //Using Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee employee2 = (Employee)context.getBean("employeeBean");
		System.out.println(employee2.getEmployeeName());
		
		//Using Annotation
		//add Component annotation to the employee class
		//add context:component scan base-package="packageName" in xml file
		
		Employee employee3 = (Employee)context.getBean("employee");
		System.out.println(employee3.getEmployeeName());
		System.out.println(employee3);
		
	}

}

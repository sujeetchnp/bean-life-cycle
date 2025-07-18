package com.spring.coreboot;

import com.spring.coreboot.beans.Samosa;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
/*
@SpringBootApplication is a convenience annotation that combines three annotations:
1. @Configuration: Indicates that the class can be used by the Spring IoC container as a source of bean definitions.
2. @EnableAutoConfiguration: Enables Spring Boot's auto-configuration feature, which automatically configures your application based on the dependencies present on the classpath.
3. @ComponentScan: Enables component scanning, allowing Spring to discover and register beans in the specified package and its sub-packages.
	This annotation is typically placed on the main class of a Spring Boot application to enable these features and simplify the configuration process.
	It is the entry point of a Spring Boot application, and it is responsible for bootstrapping the application.
	It is the main class that starts the Spring Boot application.
 */

public class CoreBootApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CoreBootApplication.class, args);
			/*
		In short:
		.run method:
			it will boot ups your spring application
				1. scans the classpath for components
				2. auto-configure the application based on the classpath
				3. start your application


		In details:
			1. create a new SpringApplication instance
			2. bootstrap the application context
			3. start the embedded server
			4. perform classpath scanning
			5. initialize all beans and DI
			6. auto-configurations
			7. start the application
		 */


		// We are getting bean from context
		Samosa samosaBean = context.getBean(Samosa.class);
		System.out.println(samosaBean);
		samosaBean.eat();

	}

}

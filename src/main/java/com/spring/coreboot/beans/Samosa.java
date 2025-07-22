/**
 *
 * Bean life cycle: IOC container started --> bean instantiation -> Dependencies injection
 *          --> Custom init logic (by interfaces like initialization and by annotation like PreDestroy) --> Bean is ready to use (all logic)
 *          --> Destroy (like @PreDestroy)
 *
 *
 * Interview Questions:
 *  Q. In initialization phase (custom init logic) : Is there any way we can write code logic and after initialization phase?
 *      Answer:  Yes, there is a way. Before : we called that pre-initialization and After: we called post-initialization
 *
 */


package com.spring.coreboot.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Samosa {

    private LocalDate localDate;
    private Scanner scanner;


    public Samosa() {
        System.out.println("Samosa bean has been created");
    }

    @PostConstruct
    public void init() {
        this.localDate = LocalDate.now();
        System.out.println("date is set to: " +localDate);
        this.scanner=new Scanner(System.in);
        System.out.println("Scanner is created");
        System.out.println("=================================");
    }

    public void eat(){
        System.out.println("you are eating samosa");
        System.out.println("Enter your name");
        String name = scanner.next();
        System.out.println(name + " is eating samosa");
        System.out.println("=========================================");

    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroying samosa bean");
        this.localDate=null;
        System.out.println("date is set to: " +localDate);
        this.scanner.close();
        System.out.println("Scanner is closed");
    }
}

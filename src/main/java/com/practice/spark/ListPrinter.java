package com.practice.spark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class ListPrinter implements CommandLineRunner {


    @Autowired
	private  Helper helper;
 
      public static void main(String[] args) {
    	  
    	  SpringApplication.run(ListPrinter.class, args);
    
    }
      
      @Override
      public void run(String... args) throws Exception {
  	
    	  System.out.println("running spring app using spring");
     	  helper.print();
     
      }
      
}

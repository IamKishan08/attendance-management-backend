package com.attendance.management.attendance.Controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  


@RestController  
public class HelloWorld {
    @RequestMapping("/")  
    public String hello()   
    {  
       return "Hello testing";  
    } 
}

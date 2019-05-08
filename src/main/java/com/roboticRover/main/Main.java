package com.roboticRover.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Efrem  on 5/3/19
 * @project java-test-project
 */

@SpringBootApplication(scanBasePackages = {"com.roboticRover"})
public class Main extends SpringBootServletInitializer {


    public static void main(String[] args){
        new Main().configure(new SpringApplicationBuilder(Main.class)).run(args);
    }



}

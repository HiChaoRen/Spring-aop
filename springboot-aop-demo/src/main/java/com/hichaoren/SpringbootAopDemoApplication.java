package com.hichaoren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication()
public class SpringbootAopDemoApplication {

    public static void main(String[] args) {

//        String[] arg = new String[1];
//        arg[0] = "--server.port=8088";

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootAopDemoApplication.class, args);
//        UserController bean = ctx.getBean(UserController.class);
//        System.out.println("bean======>" + bean);
//        TestComponent testComponent = ctx.getBean(TestComponent.class);
//        System.out.println("testComponent======>" + testComponent);
    }

}

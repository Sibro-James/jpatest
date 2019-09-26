package com.sibro.jpatest;

import com.sibro.jpatest.test.StartMain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class JpatestApplication implements CommandLineRunner{
    @Resource
    private StartMain startMain;
    public static void main(String[] args) {
        SpringApplication.run(JpatestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Thread thread = new Thread(startMain);
        thread.start();
    }
}

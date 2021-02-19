package com.zlsd.damein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: damein
 * @description:
 * @author: lidongmin
 * @create: 2021-02-19 14:40
 */
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.zlsd.*"})
public class DameinApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DameinApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.zlsd.damein.controller.limit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: damein
 * @description:
 * @author: lidongmin
 * @create: 2021-02-19 14:31
 */
@RestController
public class HelloController {


    @RequestMapping("hello")
    @AccessLimit(seconds = 5, maxCount = 0, needLogin = true)
    public String hello() {
        return "hello world SpringBoot!";
    }
}
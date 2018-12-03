package com.adifier.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * controller
 *
 * @author StevenWu
 * @create 2018-11-26-2:53 PM
 */
@RestController
public class AdifierController {

    @RequestMapping("/say")
    public String hello(){
        return "Hello Adifier!";
    }
}

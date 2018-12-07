package com.adifier.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: Create ProductaInfo Controller
 * @author: StevenWu
 * @create: 2018-12-07 15:13
 **/
@Controller
public class ProductInfoController {
    @GetMapping("/productInfos")
    public String list(){
        return "productInfos";
    }
}

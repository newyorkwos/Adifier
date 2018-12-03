package com.adifier.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * controller
 *
 * @author StevenWu
 * @create 2018-11-26-2:53 PM
 */
@RestController("/api/v1")
public class AdifierController {

    @RequestMapping("/say")
    public String hello(){
        return "Hello Adifier!";
    }

    @GetMapping("/productInfo/{id}")
    public Object getOne(@PathVariable long id){
        Map<String, Object> productInfo=new HashMap<>();
        productInfo.put("productCore","1234567890123456");
        productInfo.put("productName","test01");
        productInfo.put("barCode","0987654321");
        productInfo.put("brandId",01);
        productInfo.put("oneCategoryId","TestInfomation");
        productInfo.put("oneCategoryId",1);
        productInfo.put("twoCategoryId",2);
        productInfo.put("threeCategoryId",3);
        productInfo.put("supplierId",1);
        productInfo.put("averageCost",20L);
        productInfo.put("publishStatus",0);
        productInfo.put("audit_status",0);
        productInfo.put("description","New Test product");
        productInfo.put("indate",new Date());
        return productInfo;
    }
}

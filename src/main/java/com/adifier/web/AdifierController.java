package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/api/v1")
public class AdifierController {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/say")
    public String hello(){
        return "Hello Adifier!";
    }


    @GetMapping("/productInfo/{id}/productName/{productName:[a-z_]+}")
    public Object getOne(@PathVariable long id, @PathVariable String productName){
        Map<String, Object> productInfo=new HashMap<>();
        productInfo.put("productCore","1234567890123456");
        productInfo.put("productName",productName);
        productInfo.put("barCode","0987654321");
        productInfo.put("brandId",01);
        productInfo.put("oneCategoryId",1);
        productInfo.put("twoCategoryId",2);
        productInfo.put("threeCategoryId",3);
        productInfo.put("supplierId",1);
        productInfo.put("averageCost",20L);
        productInfo.put("publishStatus",0);
        productInfo.put("auditStatus",0);
        productInfo.put("description","New Test product");
        productInfo.put("indate",new Date());
        return productInfo;
    }

    @PostMapping("/productInfos")
    public ProductInfo post(@RequestParam String productCore,
                            @RequestParam String productName,
                            @RequestParam String barCode,
                            @RequestParam Long brandId,
                            @RequestParam int oneCategoryId,
                            @RequestParam int twoCategoryId,
                            @RequestParam int threeCategoryId,
                            @RequestParam int supplierId,
                            @RequestParam Long averageCost,
                            @RequestParam int publishStatus,
                            @RequestParam int auditStatus,
                            @RequestParam String description) {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductCore(productCore);
        productInfo.setProductName(productName);
        productInfo.put("productCore",productCore);
        productInfo.put("productName",productName);
        productInfo.put("barCode",barCode);
        productInfo.put("brandId",brandId);
        productInfo.put("oneCategoryId",oneCategoryId);
        productInfo.put("twoCategoryId",twoCategoryId);
        productInfo.put("threeCategoryId",threeCategoryId);
        productInfo.put("supplierId",supplierId);
        productInfo.put("averageCost",averageCost);
        productInfo.put("publishStatus",publishStatus);
        productInfo.put("auditStatus",auditStatus);
        productInfo.put("description",description);
        productInfo.put("indate",new Date());
        return productInfoService.save(productInfo);
    }

    @GetMapping("/productInfos")
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size){

        return productInfoService.findAll();
    }


}


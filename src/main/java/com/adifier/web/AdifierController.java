package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    /**
     * set ProductInfo jpa save method
     * @param productCore
     * @param productName
     * @param barCode
     * @param brandId
     * @param oneCategoryId
     * @param twoCategoryId
     * @param threeCategoryId
     * @param supplierId
     * @param averageCost
     * @param publishStatus
     * @param auditStatus
     * @param description
     * @return
     */
    @PostMapping("/productInfos")
    public ProductInfo post(@RequestParam String productCode,
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
        productInfo.setProductCode(productCode);
        productInfo.setProductName(productName);
        productInfo.setBarCode(barCode);
        productInfo.setBrandId(brandId);
        productInfo.setOneCategoryId(oneCategoryId);
        productInfo.setTwoCategoryId(twoCategoryId);
        productInfo.setThreeCategoryId(threeCategoryId);
        productInfo.setSupplierId(supplierId);
        productInfo.setAverageCost(averageCost);
        productInfo.setPublishStatus(publishStatus);
        productInfo.setAuditStatus(auditStatus);
        productInfo.setDescription(description);
        productInfo.setIndate(new Date());
        return productInfoService.save(productInfo);
    }

    /**
     * find ProductInfo all data list
     * @return
     */
    @GetMapping("/productInfos")
    public List<ProductInfo> getAll(){

        return productInfoService.findAll();
    }


}


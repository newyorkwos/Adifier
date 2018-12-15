package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * 描述:
 * controller
 *
 * @author StevenWu
 * @create 2018-11-26-2:53 PM
 */
@RestController
@RequestMapping("/api/v1")
public class ProductInfoApp {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/say")
    public String hello(){
        return "Hello Adifier!";
    }

    /**
     * find ProductInfo by  id
     * @param productId
     * @return
     */
    @GetMapping("/productInfo/{productId}")
    public ProductInfo getOne(@PathVariable long productId){

        return productInfoService.getOne(productId);
    }

    /**
     * set ProductInfo jpa save method
     * @return
     */
    @PostMapping("/productInfos")
    public ProductInfo post(ProductInfo productInfo) {

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
    @PutMapping("/productInfos")
    public ProductInfo update(@RequestParam long productId,
                              @RequestParam String productCode,
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
                              @RequestParam String description){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId(productId);
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
        productInfo.setIndate(new Date(System.currentTimeMillis()));

        return productInfoService.save(productInfo);
    }

    /**
     * delete ProductInfo by Id
     * @param productId
     */
    @DeleteMapping("/productInfo/{productId}")
    public void deleteById(@PathVariable long productId){

         productInfoService.deleteById(productId);
    }

}


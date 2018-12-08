package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: Create ProductaInfo Controller
 * @author: StevenWu
 * @create: 2018-12-07 15:13
 **/
@Controller
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/productInfos")
    public String list(){
        return "productInfos";
    }

    @GetMapping("/productInfo/{productId}")
    public String detail(@PathVariable long productId , Model model){
        ProductInfo productInfo=productInfoService.getOne(productId);
        if(productInfo==null){
            productInfo=new ProductInfo();
        }
        model.addAttribute("productInfo",productInfo);
        return "productInfo";
    }
}

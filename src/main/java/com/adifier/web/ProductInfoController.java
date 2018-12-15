package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @description: Create ProductaInfo Controller
 * @author: StevenWu
 * @create: 2018-12-07 15:13
 **/
@Controller
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * Get all List of ProcuctInfos
     * @param model
     * @return
     */
    @GetMapping("/productInfos")
    public String list(Model model){
        List<ProductInfo> productInfoList=productInfoService.findAll();
        model.addAttribute("productInfos",productInfoList);
        return "productInfos";
    }

    /**
     * Get productInfo detail information
     * @param productId
     * @param model
     * @return
     */
    @GetMapping("/productInfo/{productId}")
    public String detail(@PathVariable long productId , Model model){
        ProductInfo productInfo=productInfoService.getOne(productId);
        if(productInfo==null){
            productInfo=new ProductInfo();
        }
        model.addAttribute("productInfo",productInfo);
        return "productInfo";
    }

    /**
     * direct to input.html
     * @return
     */
    @GetMapping("/productInfo/input")
    public String inputPage(Model model)
    {
        model.addAttribute("productInfo", new ProductInfo());
        return "input";
    }


    /**
     * post a productInfo datum
     * @param productInfo
     * @return
     */
    @PostMapping("/productInfo")
    public String post(ProductInfo productInfo){
        productInfo.setIndate(new Date(System.currentTimeMillis()));
        productInfo.setModifiedTime(new Date(System.currentTimeMillis()));
        productInfoService.save(productInfo);
        return "redirect:/productInfos";
    }

    @GetMapping("/productInfo/{productId}/input")
    public String inputEditPage(@PathVariable long productId, Model model){
        ProductInfo productInfo=productInfoService.getOne(productId);
        model.addAttribute("productInfo", productInfo);
        return "input";
    }
}

package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

/**
 * @description: Create ProductaInfo Controller
 * @author: StevenWu
 * @create: 2018-12-07 15:13
 **/
@Controller
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    //@InitBinder
    //public void initBinder(WebDataBinder binder) {
    //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //dateFormat.setLenient(true);
    //binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    //}

    /**
     * Get all List of ProcuctInfos
     * @param model
     * @return
     */
    @GetMapping("/productInfos")
    public String list(@PageableDefault(size=5, sort={"productId"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<ProductInfo> page1=productInfoService.findAllByPage(pageable);
        model.addAttribute("page",page1);
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
    public String post(ProductInfo productInfo, final RedirectAttributes attributes){
        productInfo.setIndate(new Date(System.currentTimeMillis()));
        productInfo.setModifiedTime(new Date(System.currentTimeMillis()));
        ProductInfo productInfo1=productInfoService.save(productInfo);
        if(productInfo1 !=null){
            attributes.addFlashAttribute("message","**"+productInfo1.getProductName()+"**儲存成功");
        }
        return "redirect:/productInfos";
    }

    @GetMapping("/productInfo/{productId}/input")
    public String inputEditPage(@PathVariable long productId, Model model){

        ProductInfo productInfo=productInfoService.getOne(productId);
        model.addAttribute("productInfo", productInfo);
        return "input";
    }
}

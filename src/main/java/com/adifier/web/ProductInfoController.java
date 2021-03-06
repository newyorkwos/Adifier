package com.adifier.web;

import com.adifier.domain.ProductInfo;
import com.adifier.exception.ProductInfoNotFoundException;
import com.adifier.service.ProductInfoServiceImpl;
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
    private ProductInfoServiceImpl productInfoServiceImpl;

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
        Page<ProductInfo> page1= productInfoServiceImpl.findAllByPage(pageable);
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
    public String detail(@PathVariable long productId , Model model) {
        ProductInfo productInfo= productInfoServiceImpl.getOne(productId);
        if(productInfo==null){
            //throw new RuntimeException("找不到該筆資料");
            throw new ProductInfoNotFoundException("找不到該筆資料");
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
        ProductInfo productInfo1= productInfoServiceImpl.save(productInfo);
        if(productInfo1 !=null){
            attributes.addFlashAttribute("message","**"+productInfo1.getProductName()+"**儲存成功");
        }
        return "redirect:/productInfos";
    }

    /**
     * add or edit product
     * @param productId
     * @param model
     * @return
     */
    @GetMapping("/productInfo/{productId}/input")
    public String inputEditPage(@PathVariable long productId, Model model){

        ProductInfo productInfo= productInfoServiceImpl.getOne(productId);
        model.addAttribute("productInfo", productInfo);
        return "input";
    }

    /**
     * delete product by productId
     * @param productId
     * @param attributes
     * @return
     */
    @GetMapping("/productInfos/{productId}/delete")
    public String delete(@PathVariable long productId, final RedirectAttributes attributes){
        productInfoServiceImpl.deleteById(productId);
        attributes.addFlashAttribute("message","刪除成功");
        return "redirect:/productInfos";
    }

    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException("測試異常");
    }
}

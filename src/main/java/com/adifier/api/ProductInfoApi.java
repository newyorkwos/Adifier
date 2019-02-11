package com.adifier.api;

import com.adifier.domain.ProductInfo;
import com.adifier.dto.ProductInfoDTO;
import com.adifier.exception.InvalidRequestException;
import com.adifier.exception.ProductInfoNotFoundException;
import com.adifier.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
public class ProductInfoApi {

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
    public Page<ProductInfo> getAll(@PageableDefault(size=5, sort={"productId"}, direction = Sort.Direction.DESC) Pageable pageable){

        return productInfoService.findAllByPage(pageable);
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

    /**
     * get all productInfos
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<?> listAllProducts(){
        List<ProductInfo> productInfos=productInfoService.findAll();
        if(productInfos.isEmpty()){
            throw new ProductInfoNotFoundException("Products Not found");
        }
        return new ResponseEntity<List<ProductInfo>>(productInfos, HttpStatus.OK);
    }

    /**
     * get One productInfo by Id
     * @param productInfoId
     * @return
     */
    @GetMapping("products/{productInfoId}")
    public ResponseEntity<?> getProductInfo(@PathVariable Long productInfoId){
        ProductInfo productInfo=productInfoService.getOne(productInfoId);
        if(productInfo==null){
            throw new ProductInfoNotFoundException(String.format("productInfo ID %s not found", productInfoId));
        }
        return new ResponseEntity<Object>(productInfo, HttpStatus.OK);
    }

    /**
     * save a productInfo
     * @param productInfo
     * @return
     */
    @PostMapping("/products")
    public ResponseEntity<?> saveProductInfo(@Valid @RequestBody ProductInfo productInfo, BindingResult bindResult){

        if(bindResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameters", bindResult);
        }
        ProductInfo productInfo1=productInfoService.save(productInfo);
        return new ResponseEntity<Object>(productInfo1, HttpStatus.CREATED);
    }

    /**
     * update productInfo
     * @param productInfoId
     * @param productInfoDTO
     * @return
     */
    @PutMapping("/products/{productInfoId}")
    public ResponseEntity<?> updateProductInfo(@PathVariable Long productInfoId, @Valid @RequestBody ProductInfoDTO productInfoDTO, BindingResult bindingResult){
        ProductInfo currentProductInfo=productInfoService.getOne(productInfoId);
        if(currentProductInfo==null){
            throw new ProductInfoNotFoundException(String.format("productInfo by id % not found", productInfoId));
        }
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter", bindingResult);
        }
        productInfoDTO.convertToProductInfo(currentProductInfo);
        ProductInfo productInfo1=productInfoService.update(currentProductInfo);
        return new ResponseEntity<Object>(productInfo1, HttpStatus.OK);
    }




    /**
     * delete productInfo
     * @param productInfoId
     * @return
     */
    @DeleteMapping("/products/{productInfoId}")
    public ResponseEntity<?> deleteProductInfo(@PathVariable Long productInfoId){
        productInfoService.deleteById(productInfoId);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    /**
     * delete all ProductInfo
     * @return
     */
    @DeleteMapping("/products")
    public ResponseEntity<?> deleteAllProductInfo(){
        productInfoService.deleteAll();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}


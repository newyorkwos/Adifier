package com.adifier.service;

import com.adifier.domain.ProductInfo;
import com.adifier.domain.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Create ProductInfo Service Class
 *
 * @author StevenWu
 * @create 2018-12-04-23:57
 */
@Service
public class ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * find all productInfos list
     * @return
     */
    public List<ProductInfo> findAll(){
        return productInfoRepository.findAll();
    }

    /**
     * add or update  a productInfo datum
     * @param productInfo
     * @return
     */
    public ProductInfo save(ProductInfo productInfo){
        return productInfoRepository.save(productInfo);
    }

    /**
     * get one ProductInfo datum
     * @param productId
     * @return
     */
    public ProductInfo getOne(long productId){
        return productInfoRepository.findById(productId).orElse(null);
    }

    /**
     * delete productInfno by productId
     * @param productId
     */
    public void deleteById(long productId){
        productInfoRepository.deleteById(productId);
    }
}
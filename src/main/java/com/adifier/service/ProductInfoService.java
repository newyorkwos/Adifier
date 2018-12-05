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
     * add new a productInfo data
     * @param productInfo
     * @return
     */
    public ProductInfo save(ProductInfo productInfo){
        return productInfoRepository.save(productInfo);
    }
}

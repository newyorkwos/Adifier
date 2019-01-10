package com.adifier.service;

import com.adifier.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    List<ProductInfo> findAll();
    Page<ProductInfo> findAllByPage(Pageable pageable);
    ProductInfo getOne(Long productId);
    ProductInfo save(ProductInfo productInfo);
    ProductInfo update(ProductInfo productInfo);
    void deleteById(Long productId);
    void deleteAll();

}

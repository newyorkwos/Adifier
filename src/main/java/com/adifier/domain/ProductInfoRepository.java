package com.adifier.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    Page<ProductInfo> findAllByPage(Pageable pageable);
}

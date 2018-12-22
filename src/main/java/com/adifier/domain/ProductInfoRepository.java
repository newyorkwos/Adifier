package com.adifier.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    Page<ProductInfo> findAllByPage(Pageable pageable);
}

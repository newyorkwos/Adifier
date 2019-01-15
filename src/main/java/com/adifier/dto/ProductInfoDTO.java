package com.adifier.dto;

import com.adifier.domain.ProductInfo;
import com.adifier.util.CustomBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @description: create ProductInfoDTO
 * @author: StevenWu
 * @create: 2019-01-14 16:08
 **/

public class ProductInfoDTO {


    private String productCode;
    private String productName;
    private String barCode ;
    private Long brandId;
    private int oneCategoryId ;
    private int twoCategoryId;
    private int threeCategoryId;
    private int supplierId;
    private Long averageCost;
    private int publishStatus;
    private int auditStatus;
    private Float weight;
    private Float length;
    private Float height;
    private Float width;
    private String colorType;
    private Date productionDate;
    private Date shelfLife;
    private String description;
    private Date indate;
    private Date modifiedTime;
    public ProductInfoDTO() {
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public int getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(int oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public int getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(int twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public int getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(int threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Long getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(Long averageCost) {
        this.averageCost = averageCost;
    }

    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int audit_status) {
        this.auditStatus = auditStatus;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {

        this.productionDate = productionDate;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 轉換傳輸對象
     * @param productInfo
     */
    public void convertToProductInfo(ProductInfo productInfo){
        new ProductInfoConvert().convert(this, productInfo);
    }

    private class ProductInfoConvert implements Convert<ProductInfoDTO, ProductInfo>{
        @Override
        public ProductInfo convert(ProductInfoDTO productInfoDTO, ProductInfo productInfo) {
            String[] nullPropertyNames= CustomBeanUtils.getNullpropertyNames(productInfoDTO);
            BeanUtils.copyProperties(productInfoDTO, productInfo, nullPropertyNames);
            return productInfo;
        }

        @Override
        public ProductInfo convert(ProductInfoDTO productInfoDTO) {
            return null;
        }
    }
}

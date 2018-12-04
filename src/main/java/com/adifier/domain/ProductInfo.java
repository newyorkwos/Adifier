package com.adifier.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 * create Product Information Table
 *
 * @author StevenWu
 * @create 2018-12-02-21:25
 */
@Entity
public class ProductInfo {
    //商品ID
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long productId;
    //商品编码
    @Column(nullable =false, length=16)
    private String productCore;
    //商品名稱
    @Column(nullable =false, length=20)
    private String productName;
    //國條碼
    @Column(nullable =false, length=50)
    private String barCode ;
    //品牌ID
    @Column(nullable =false)
    private Long brandId;
    //一級分類ID
    @Column(nullable =false)
    private int oneCategoryId ;
    //二級分類ID
    @Column(nullable =false)
    private int twoCategoryId;
    //三級分類ID
    @Column(nullable =false)
    private int threeCategoryId;
    //供應商ID*******
    @Column(nullable =false)
    private int supplierId;
    //商品平均加權成本
    @Column(nullable =false)
    private Long averageCost;
    //上架狀態：0下架 1上架
    @Column(nullable =false,length=1)
    private int publishStatus;
    //審核狀態 0未審核 1已審核
    @Column(nullable =false,length=1)
    private int auditStatus;
    //商品重量
    private Float weight;
    //商品長度
    private Float length;
    //商品高度
    private Float height;
    //商品寬度
    private Float width;
    //顏色
    private String colorType;
    //生產日期
    private Date productionDate;
    //商品有效期限
    private Date shelfLife;
    //商品描述
    @Column(nullable =false)
    private String description;
    //商品登錄時間
    @Column(nullable =false,length=1)
    private Date indate;
    //最後修改時間
    private Date modifiedTime;

    public ProductInfo() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCore() {
        return productCore;
    }

    public void setProductCore(String productCore) {
        this.productCore = productCore;
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

    public int getAudit_status() {
        return auditStatus;
    }

    public void setAudit_status(int audit_status) {
        this.auditStatus = audit_status;
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
}

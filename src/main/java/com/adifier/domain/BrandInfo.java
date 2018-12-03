package com.adifier.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 * Create Brand Information
 *
 * @author StevenWu
 * @create 2018-12-02-23:30
 */
@Entity
public class BrandInfo {
    //品牌ID
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long brandId;
    //品牌名稱
    @Column(nullable =false, length=50)
    private String brandName;
    //聯繫電話
    @Column(nullable =false, length=50)
    private String telephone;
    //品牌URL
    @Column(length=100)
    private String brandWeb;
    //品牌Logo
    @Column(length=100)
    private String brandLogo;
    //品牌描述
    @Column(length=150)
    private String brandDesc;
    //品牌狀態 0禁用 1啟用
    @Column(length=1)
    private int brandStatus;
    //排序
    private int brandOrder;
    //最後修改時間
    private Date modifiedTime;

    public BrandInfo() {
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBrandWeb() {
        return brandWeb;
    }

    public void setBrandWeb(String brandWeb) {
        this.brandWeb = brandWeb;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public int getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(int brandStatus) {
        this.brandStatus = brandStatus;
    }

    public int getBrandOrder() {
        return brandOrder;
    }

    public void setBrandOrder(int brandOrder) {
        this.brandOrder = brandOrder;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}

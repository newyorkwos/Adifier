package com.adifier.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 * Create Supplyer Information
 *
 * @author StevenWu
 * @create 2018-12-02-23:14
 */
@Entity
public class SupplierInfo {
    //供應商ID
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long supplierId;
    //供應商編碼
    private String supplier_code;
    //供應商名稱
    @Column(nullable =false, length=50)
    private String supplierName; //CHAR(50) NOT NULL COMMENT '供应商名称',
    //供應商類型 1.自營 2.平台
    private int supplierType ;
    //供應商聯繫人
    @Column(nullable =false, length=50)
    private String linkMan;
    //供應商電話
    @Column(nullable =false, length=50)
    private String phoneNumber;
    //供應商開戶銀行名稱
    @Column(nullable =false, length=50)
    private String bankName;
    @Column(nullable =false, length=50)
    private String bankAccount;
    //供應商地址
    @Column(nullable =false, length=200)
    private String address;
    //狀態 0.禁止 1.啟用
    @Column(nullable =false, length=1)
    private int supplierStatus;
    //最後修改時間
    private Date modifiedTime;

    public SupplierInfo() {
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier_code() {
        return supplier_code;
    }

    public void setSupplier_code(String supplier_code) {
        this.supplier_code = supplier_code;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(int supplierType) {
        this.supplierType = supplierType;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(int supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}

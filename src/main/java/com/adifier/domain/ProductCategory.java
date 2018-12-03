package com.adifier.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 * Create Product Category Table
 *
 * @author StevenWu
 * @create 2018-12-02-23:43
 */
@Entity
public class ProductCategory {
    //
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String categoryId;
    //分類名稱
    @Column(nullable =false, length=10)
    private String categoryName;
    //分類編碼
    @Column(nullable =false, length=10)
    private String categoryCode;
    //父分類Id
    @Column(nullable =false)
    private int parentId;
    //分類層級
    @Column(nullable =false)
    private int categoryLevel;
    //分類狀態
    @Column(nullable =false)
    private int category_status;
    //最後修改時間
    private Date modified_time;

    public ProductCategory() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(int categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public int getCategory_status() {
        return category_status;
    }

    public void setCategory_status(int category_status) {
        this.category_status = category_status;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }
}

package com.products.manager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String titel;
    private String description;
    private Long gtin;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String productCode;

    public Product() {
    }

    public Product(Long id, String titel, String description, Long gtin, String phone, String imageUrl, String productCode) {
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.gtin = gtin;
        this.imageUrl = imageUrl;
        this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGtin() {
        return gtin;
    }

    public void setGtin(Long gtin) {
        this.gtin = gtin;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", description='" + description + '\'' +
                ", gtin=" + gtin +
                ", imageUrl='" + imageUrl + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}

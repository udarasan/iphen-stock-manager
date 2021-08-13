package com.iphentechnologies.stockmanager.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productID;
    private String productName;
    private String productCategory;
    private String productCode;
    private String productDesc;
    private String productAddDate;
    private int productQTY;
}

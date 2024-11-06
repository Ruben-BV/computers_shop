package org.factoriaf5.computers_shop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private double memory;
    @Column(nullable = false)
    private String processor;
    @Column(nullable = false)
    private String operatingSystem;
    @Column(nullable = false)
    private double price;
    
    
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
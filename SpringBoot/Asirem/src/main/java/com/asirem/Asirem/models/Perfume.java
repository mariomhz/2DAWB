package com.asirem.Asirem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "perfumes")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String brand;
    private Double price;
    private String description;

    //Constructors
    public Perfume() {}
    public Perfume(Integer id, String name, String brand, Double price, String description) {
        setId(id);
        setName(name);
        setBrand(brand);
        setPrice(price);
        setDescription(description);
    }

    //Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}

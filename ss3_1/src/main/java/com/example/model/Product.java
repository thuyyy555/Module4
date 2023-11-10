package com.example.model;

public class Product {
    private String id;
    private String name;
    private Double price;
    private String des;
    private String producer;

    public Product() {
    }

    public Product(String id, String name, Double price, String des, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

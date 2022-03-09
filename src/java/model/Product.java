/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Product {
    private int id;
    private String name;
    private Category category;
    private Company company;
    private String discription;
    private float cost;
    private float price;
    private float weightPerBag;

    public Product() {
    }

    public Product(int id, String name, Category category, Company company, String discription, float cost, float price, float weightPerBag) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.company = company;
        this.discription = discription;
        this.cost = cost;
        this.price = price;
        this.weightPerBag = weightPerBag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeightPerBag() {
        return weightPerBag;
    }

    public void setWeightPerBag(float weightPerBag) {
        this.weightPerBag = weightPerBag;
    }
    
}

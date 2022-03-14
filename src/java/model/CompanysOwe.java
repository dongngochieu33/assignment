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
public class CompanysOwe {
    private OrderDetail orderDetail;
    private OrderHistory orderHistory;
    private Product product;
    private Company company;
    private double oweMoney;

    public double getOweMoney() {
        return oweMoney;
    }

    public void setOweMoney(double oweMoney) {
        this.oweMoney = oweMoney;
    }

    public CompanysOwe() {
    }

    public CompanysOwe(OrderDetail orderDetail, OrderHistory orderHistory, Product product, Company company, double oweMoney) {
        this.orderDetail = orderDetail;
        this.orderHistory = orderHistory;
        this.product = product;
        this.company = company;
        this.oweMoney = oweMoney;
    }

    

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
}

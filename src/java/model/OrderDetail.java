/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class OrderDetail {
    private OrderHistory orderHistory;
   private Product product;
   private int quantity;
   private float discount;
   private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public OrderDetail() {
    }

    public OrderDetail(OrderHistory orderHistory, Product product, int quantity, float discount, float total) {
        this.orderHistory = orderHistory;
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
   
    
}

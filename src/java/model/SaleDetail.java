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
public class SaleDetail {
    private SaleHistory saleHistory;
    private Product pro;
    private int quantity;
    private float discount;

    public SaleDetail() {
    }

    public SaleDetail(SaleHistory saleHistory, Product pro, int quantity, float discount) {
        this.saleHistory = saleHistory;
        this.pro = pro;
        this.quantity = quantity;
        this.discount = discount;
    }

    public SaleHistory getSaleHistory() {
        return saleHistory;
    }

    public void setSaleHistory(SaleHistory saleHistory) {
        this.saleHistory = saleHistory;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
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

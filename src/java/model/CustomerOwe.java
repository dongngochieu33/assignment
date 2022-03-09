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
public class CustomerOwe {
    private Customer cus; 
    private SaleHistory saleHistory;
    private SaleDetail saleDetail;
    private Product pro;

    public CustomerOwe() {
    }

    public CustomerOwe(Customer cus, SaleHistory saleHistory, SaleDetail saleDetail, Product pro) {
        this.cus = cus;
        this.saleHistory = saleHistory;
        this.saleDetail = saleDetail;
        this.pro = pro;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public SaleHistory getSaleHistory() {
        return saleHistory;
    }

    public void setSaleHistory(SaleHistory saleHistory) {
        this.saleHistory = saleHistory;
    }

    public SaleDetail getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(SaleDetail saleDetail) {
        this.saleDetail = saleDetail;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }
    
}

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
public class OrderHistory {
    private int id;
    private Date orderDate;
    private Date maturityDate;
    private float paid;
    private Company company;
    private float total;

    public OrderHistory() {
    }

    public OrderHistory(int id, Date orderDate, Date maturityDate, float paid, Company company, float total) {
        this.id = id;
        this.orderDate = orderDate;
        this.maturityDate = maturityDate;
        this.paid = paid;
        this.company = company;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    
    
    
  

   
}

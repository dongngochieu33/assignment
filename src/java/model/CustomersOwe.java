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
public class CustomersOwe {
    private SaleHistory salehistory;
    private Customer cus;
    private Address add;
    private float ownMoney;

    public CustomersOwe() {
    }

    public CustomersOwe(SaleHistory salehistory, Customer cusl, Address add, float ownMoney) {
        this.salehistory = salehistory;
        this.cus = cusl;
        this.add = add;
        this.ownMoney = ownMoney;
    }

    public SaleHistory getSalehistory() {
        return salehistory;
    }

    public void setSalehistory(SaleHistory salehistory) {
        this.salehistory = salehistory;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public float getOwnMoney() {
        return ownMoney;
    }

    public void setOwnMoney(float ownMoney) {
        this.ownMoney = ownMoney;
    }
    
}

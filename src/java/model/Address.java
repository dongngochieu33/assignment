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
public class Address {
    private int id;
    private String xom;

    public Address() {
    }

    public Address(int id, String xom) {
        this.id = id;
        this.xom = xom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXom() {
        return xom;
    }

    public void setXom(String xom) {
        this.xom = xom;
    }
    
     
}

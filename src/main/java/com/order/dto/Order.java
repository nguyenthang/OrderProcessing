package com.order.dto;

/**
 * Created by thangnguyen-imac on 6/23/16.
 */
public class Order {

    private String status;

    private int id;

    public Order(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

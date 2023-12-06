package com.springclient.springclient.controllers;

public class Stocks {
    public Stocks(String name, double pricce) {
        this.name = name;
        this.price = pricce;
    }

    public Stocks() {
    }

    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.pillar;

public class Item {
    private String name;
    private double price;
    private double markedDown;      // It can be 0.20 reduce in price if there is a markedDown
    private String special;         // There can be a special offer like "Buy one get one free"

    public Item(String name, double price, double markedDown, String special){
        this.name = name;
        this.price = price;
        this.markedDown = markedDown;
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMarkedDown() {
        return markedDown;
    }

    public void setMarkedDown(double markedDown) {
        this.markedDown = markedDown;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}

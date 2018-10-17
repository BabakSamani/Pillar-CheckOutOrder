package com.pillar;

public class Orders {
    private Item item;
    private double quntiyt;

    // Class constructor
    public Orders(Item item, double quantity){
        this.item = item;
        this.quntiyt = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuntiyt() {
        return quntiyt;
    }

    public void setQuntiyt(double quntiyt) {
        this.quntiyt = quntiyt;
    }

    public double totalCost(Item item, double quntity){
        return item.getPrice() * quntity;
    }
}

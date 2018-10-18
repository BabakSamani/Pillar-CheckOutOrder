package com.pillar;

import org.json.JSONException;
import org.json.JSONObject;

public class Orders {
    private Item item;
    private double quantity;
    private String date;

    // Class constructor
    public Orders(Item item, double quantity, String date) {
        this.item = item;
        this.quantity = quantity;
        this.date = date;

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void createJsonObject(Item item, double quantity, String date) throws JSONException{

        JSONObject orderObj = new JSONObject();
        orderObj.put("item", item);
        orderObj.put("quantity", quantity);
        orderObj.put("date", date);

        System.out.print(orderObj);

    }
}

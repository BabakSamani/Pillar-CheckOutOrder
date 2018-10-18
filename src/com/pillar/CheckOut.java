package com.pillar;


public class CheckOut {

    public CheckOut(){ }

    public double CalculateTotalCost(Orders orders){
        double totalCost = 0.00;

        // Get special offer if exists for this order
        String special = orders.getItem().getSpecial();

        if (!special.equals("None")){
            if(special.equals("Buy 1 get 1 free")){
                System.out.println("1 free item");
            }
        }else{
            totalCost = ( orders.getItem().getPrice() - orders.getItem().getMarkedDown() ) * orders.getQuantity();
        }

        return totalCost;
    }
}

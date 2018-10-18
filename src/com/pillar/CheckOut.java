package com.pillar;


public class CheckOut {

    public CheckOut(){ }

    public double CalculateTotalCost(Orders orders){
        double totalCost = 0.00;

        // Get special offer if exists for this order
        String special = orders.getItem().getSpecial();

        if (!special.equals("None")){
            if( special.equals("Buy 1 get 1 free") && orders.getQuantity() == 2 ){
                System.out.println("1 free item for buying 1 item!");
                totalCost = ( orders.getItem().getPrice() - orders.getItem().getMarkedDown() ) * (orders.getQuantity() - 1);
            }
            if( special.equals("Buy 2 get 1 free") && orders.getQuantity() >= 2){
                // Buy N items and get M items free --> quantity = quantity - M
                System.out.println("1 free item for buying 2 items!");
                totalCost = ( orders.getItem().getPrice() - orders.getItem().getMarkedDown() ) * (orders.getQuantity() - 1);
            }
        }else{
            totalCost = ( orders.getItem().getPrice() - orders.getItem().getMarkedDown() ) * orders.getQuantity();
        }

        return totalCost;
    }
}

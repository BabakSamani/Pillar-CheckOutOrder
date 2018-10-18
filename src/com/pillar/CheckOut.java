package com.pillar;

import java.util.regex.*;


public class CheckOut {

    public CheckOut() {
    }

    public double CalculateTotalCost(Orders orders) {

        double totalCost = (orders.getItem().getPrice() - orders.getItem().getMarkedDown()) * orders.getQuantity();

        // Get special offer if exists for this order
        String special = orders.getItem().getSpecial();
        special = special.toLowerCase();

        if (!special.equals("none")) {

            // Setting up the special offer for "Buy N items and get M items free
            Pattern BuyNGetMFree = Pattern.compile("buy\\s([0-9]+)\\sget\\s([0-9]+)\\sfree");
            Matcher matcher_NMFree = BuyNGetMFree.matcher(special);
            Pattern p; Matcher m;
            double N,M;
            if (matcher_NMFree.find()) {
                // Now extract the N and M numbers from string
                p = Pattern.compile("\\d+");
                m = p.matcher(special);
                double numbers[] = new double[2];
                int i = 0;
                while (m.find()) {
                    numbers[i] = Double.parseDouble(m.group());
                    i++;
                }

                N = numbers[0];
                M = numbers[1];

                totalCost = (orders.getItem().getPrice() - orders.getItem().getMarkedDown()) * (orders.getQuantity() - M);

                System.out.printf("Total Cost: %f\n", Round(totalCost,2));
            }

            // Setting up the special offer for "Buy N items get M half off"
            // Buy 1 get 1 half off
            Pattern BuyNGetMHalfOff = Pattern.compile("buy\\s([0-9]+)\\sget\\s([0-9]+)\\shalf\\soff");
            Matcher matcher_NMHalf = BuyNGetMHalfOff.matcher(special);

            if (matcher_NMHalf.find()){
                // Extract N and M from string
                p = Pattern.compile("\\d+");
                m = p.matcher(special);
                double numbers[] = new double[2];
                int i = 0;
                while (m.find()) {
                    numbers[i] = Double.parseDouble(m.group());
                    i++;
                }

                N = numbers[0];
                M = numbers[1];

                totalCost = (orders.getItem().getPrice() - orders.getItem().getMarkedDown()) * N;
                totalCost += (orders.getItem().getPrice()/2 - orders.getItem().getMarkedDown()) * M;
            }

            //Setting up the special offer for "Buy N items get M at %X off"
        }

        return totalCost;
    }

    // A method to round a number to n decimal places
    public static double Round(double number, double places) {
        double result = 0.00;
        try {
            long factor = (long) Math.pow(10, places);
            number = number * factor;
            long l = Math.round(number);
            result = (double) l / factor;

        } catch (IllegalArgumentException error) {
            System.out.println(error);
        }

        return result;
    }

}

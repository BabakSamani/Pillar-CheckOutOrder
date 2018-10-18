package com.pillar;

import java.util.regex.*;


public class CheckOut {

    public CheckOut() {
    }

    public double CalculateTotalCost(Orders orders) {
        double totalCost = 0.00;

        // Get special offer if exists for this order
        String special = orders.getItem().getSpecial();
        special = special.toLowerCase();

        if (!special.equals("none")) {
            // Setting up the special offer for "Buy N items and get M items free
            Pattern BuyNGetMFree = Pattern.compile("buy\\s([0-9]+)\\sget\\s([0-9]+)\\sfree");
            Pattern BuyNGetMHalfOff = Pattern.compile("buy\\s([0-9]+)\\sget\\s([0-9]+)\\shalf\\soff");

            Matcher matcher_NMFree = BuyNGetMFree.matcher(special);
            Matcher matcher_NMHalf = BuyNGetMHalfOff.matcher(special);

            if (matcher_NMFree.find() || matcher_NMHalf.find()) {
                // Now extract the N and M numbers from string
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(special);
                double numbers[] = new double[2];
                int i = 0;
                while (m.find()) {
                    numbers[i] = Double.parseDouble(m.group());
                    i++;
                }

                double N = numbers[0];
                double M = numbers[1];

                totalCost = (orders.getItem().getPrice() - orders.getItem().getMarkedDown()) * (orders.getQuantity() - M);

                System.out.printf("Total Cost: %f\n", Round(totalCost,2));
            }

        } else {
            totalCost = (orders.getItem().getPrice() - orders.getItem().getMarkedDown()) * orders.getQuantity();
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

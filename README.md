# Pillar-codingChallenge-checkoutOrder
A coding challenge for creating a Test-Driven Development application in Java. Based on my understanding of Kata Problem
 Solving and programming, four steps should be taken in developing an application with this method, design, develop, 
 test and produce.

This challenge is about developing a check out process that can calculate the total cost of an order that includes a 
list of items. Some items in the order might have markedDown or special offers that would effect the total cost. 

Design
------------------------------------------------------------------------------------------------------------------------
Java object oriented programming is applied for developing this application, and ``org.junit.Test, 
junit.framework.TestCase.assertEquals`` packages are imported to create the test classes and check whether the produced
classes can pass the test cases.
Initially, the following steps are applied for designing the application.

> Need to have Items or products, need to have Orders for each customer. An arrayList to create the order that enables 
us for removing any item from order list.\
> markedDownItems pool includes items that have discount. An arrayList to create this pool.\
> Need to have CheckOut process. In this step the calculation will be applied.
>

Development
------------------------------------------------------------------------------------------------------------------------

Test
------------------------------------------------------------------------------------------------------------------------
There are several initial test cases that has to be applied for testing this application. The application should be able
to calculate total cost of scanned items for the following test cases:
1. Reduce total cost for items that a markedDown/discount is applied.
2. Reduce total cost for special offer: "Buy N items get M at %X off." 
    For example, "Buy 1 get 1 free" or "Buy 2 get 1 half off."
3. Reduce total cost for special offer: "N for $X." For example, "3 for $5.00".
4. Reduce total cost for special offer is applied and there is limitation for purchasing items, for example, "buy 3 get 
1 free, limit 5".
5. Reduce total cost if an item/items is/are removed from the orders' list.
6. Reduce total cost when the test case is "Buy N, get M of equal or lesser value for %X off" on weighted items.

Production
------------------------------------------------------------------------------------------------------------------------

import com.pillar.Item;
import com.pillar.Orders;
import com.pillar.CheckOut;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class checkOutOrderTest {
    private Item item;
    private Orders order;
    private CheckOut checkOutProcess;

    @Before
    public void setUp(){
        item = new Item();
        checkOutProcess = new CheckOut();
    }

    // In the following test cases an order has only one item
    @Test
    public void whenAnItemWithEachUnitIsAddedToOrderReturnsTotalCost(){
        item.setName("Soup");
        item.setPrice(1.89);
        item.setMarkedDown(0.00);
        item.setSpecial("None");


        double quantity = 2; // This item is sold at an "each" price.
        order = new Orders(item, quantity, "10/17/2018");

        double totalCost = checkOutProcess.CalculateTotalCost(order);

        assertEquals( 2*1.89, totalCost );

    }

    @Test
    public void whenAnItemWithWeightUnitIsAddedToOrderReturnsTotalCost(){

        item.setName("Banana");
        item.setPrice(2.38);
        item.setMarkedDown(0.00);
        item.setSpecial("None");

        double quantity = 3.38; // This item is sold by "weight"

        order = new Orders(item, quantity, "10/17/2018");

        double totalCost = checkOutProcess.CalculateTotalCost(order);

        assertEquals(3.38 * 2.38, totalCost);
    }

    // Test cases with markedDowns
    @Test
    public void whenAnItemByEachUnitWithMarkedDownIsAddedToOrderReturnsTotalCost(){
        item.setName("Honey");
        item.setPrice(5.67);
        item.setMarkedDown(0.50); // $0.50 markedDown applied for this item
        item.setSpecial("None");

        double quantity = 2;

        order = new Orders(item, quantity, "10/17/2018");

        double totalCost = checkOutProcess.CalculateTotalCost(order);

        assertEquals(2*(5.67-0.50), totalCost);

    }

    @Test
    public void whenAnItemByWeightUnitWithMarkedDownIsAddedToOrderReturnsTotalCost(){

        item.setName("80% lean ground beef");
        item.setPrice(5.99);
        item.setMarkedDown(0.75); // $0.75 markedDown per LB applied for this item
        item.setSpecial("None");

        double quantity = 3.67;

        order = new Orders(item, quantity, "10/17/2018");

        double totalCost = checkOutProcess.CalculateTotalCost(order);

        assertEquals(3.67*(5.99-0.75), totalCost);
    }

    // Test cases with specials for items that are sold by each
    @Test
    public void whenAnItemByEachUnitPriceAndSpecialOfferIsAddedToOrderReturnTotalCost(){
        double quantity, totalCost;
        item.setName("Dove body wash");
        item.setPrice(5.94);
        item.setMarkedDown(0.00);

        item.setSpecial("Buy 1 get 1 free");
        quantity = 2;
        order = new Orders(item, quantity, "10/18/2018");
        totalCost = checkOutProcess.CalculateTotalCost(order);
        assertEquals((2-1)*(5.94-0.00), totalCost);

        item.setSpecial("Buy 2 get 1 free");
        quantity = 3;
        order = new Orders(item, quantity, "10/18/2018");
        totalCost = checkOutProcess.CalculateTotalCost(order);
        assertEquals((3-1)*(5.94-0.00), totalCost);

        item.setSpecial("Buy 2 get 1 half off");
        quantity = 3;
        order = new Orders(item, quantity, "10/18/2018");
        totalCost = checkOutProcess.CalculateTotalCost(order);
        assertEquals((2*5.94) + (5.94/2), totalCost);

        item.setSpecial("Buy 2 get 1 at %50 off");
        quantity = 3;
        order = new Orders(item, quantity, "10/18/2018");
        totalCost = checkOutProcess.CalculateTotalCost(order);
        assertEquals((2*5.94) + (5.94/2), totalCost);

        item.setSpecial("Buy 2 get 1 at %30 off");
        quantity = 3;
        order = new Orders(item, quantity, "10/18/2018");
        totalCost = checkOutProcess.CalculateTotalCost(order);
        assertEquals((2*5.94) + (5.94*0.7), totalCost);

        item.setSpecial("3 for $5.50");
        quantity = 3;
        order = new Orders(item, quantity, "10/18/2018");
        totalCost = checkOutProcess.CalculateTotalCost(order);
        assertEquals(3*5.00, totalCost);
        // "N for $X." For example, "3 for $5.00"
    }


}

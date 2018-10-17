import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import com.pillar.Item;
import com.pillar.Orders;


public class checkOutOrderTest {

    // In the following test cases an order has only one item
    @Test
    public void whenAnItemWithEachUnitIsAddedToOrderReturnsTotalCost(){

        Item item = new Item("Soup", 1.89, 0.00, "None");
        double quantity = 2; // This item is sold at an "each" price.
        Orders order = new Orders(item, quantity);

        assertEquals( 2*1.89, order.totalCost(item, quantity) );

    }

    @Test
    public void whenAnItemWithWeightUnitIsAddedToOrderReturnsTotalCost(){

        Item item = new Item("Banana", 2.38, 0.00, "None");
        double quantity = 3.38; // This item is sold by "weight"

        Orders order = new Orders(item, quantity);

        assertEquals(3.38 * 2.38, order.totalCost(item, quantity));
    }

    // Test cases with markedDowns
    @Test
    public void whenAnItemByEachUnitWithMarkedDownIsAddedToOrderReturnsTotalCost(){

    }

}

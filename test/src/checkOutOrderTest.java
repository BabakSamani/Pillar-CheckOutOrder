import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import com.pillar.Item;
import com.pillar.Orders;


public class checkOutOrderTest {
    private Item item;
    private Orders order;

    @Before
    public void setUp(){
        item = new Item();
    }

    // In the following test cases an order has only one item
    @Test
    public void whenAnItemWithEachUnitIsAddedToOrderReturnsTotalCost(){
        item.setName("Soup");
        item.setPrice(1.89);
        item.setMarkedDown(0.00);
        item.setSpecial("None");

        double quantity = 2; // This item is sold at an "each" price.
        order = new Orders(item, quantity);

        assertEquals( 2*1.89, order.totalCost(item, quantity) );

    }

    @Test
    public void whenAnItemWithWeightUnitIsAddedToOrderReturnsTotalCost(){

        item.setName("Banana");
        item.setPrice(2.38);
        item.setMarkedDown(0.00);
        item.setSpecial("None");

        double quantity = 3.38; // This item is sold by "weight"

        order = new Orders(item, quantity);

        assertEquals(3.38 * 2.38, order.totalCost(item, quantity));
    }

    // Test cases with markedDowns
    @Test
    public void whenAnItemByEachUnitWithMarkedDownIsAddedToOrderReturnsTotalCost(){
        item.setName("Honey");
        item.setPrice(5.67);
        item.setMarkedDown(0.50); // $0.50 markedDown applied for this item
        item.setSpecial("None");

        double quantity = 2;

        order = new Orders(item, quantity);

        assertEquals(2*(5.67-0.50), order.totalCost(item, quantity));

    }

    @Test
    public void whenAnItemByWeightUnitWithMarkedDownIsAddedToOrderReturnsTotalCost(){

        item.setName("80% lean ground beef");
        item.setPrice(5.99);
        item.setMarkedDown(0.75); // $0.75 markedDown per LB applied for this item
        item.setSpecial("None");

        double quantity = 3.67;

        order = new Orders(item, quantity);

        assertEquals(3.67*(5.99-0.75), order.totalCost(item, quantity));
    }
}

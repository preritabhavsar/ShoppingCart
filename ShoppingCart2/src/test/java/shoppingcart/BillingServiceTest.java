package shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inventory.InventoryService;
import inventory.Item;
import shop.BillingService;
import shop.CartService;

class BillingServiceTest {

	private BillingService billingService;
	private CartService cartService;

	static Map<String, Item> inventory = new HashMap<>();

	@BeforeEach
	void setUp() throws Exception {
		this.billingService = new BillingService();
		this.cartService = new CartService();
	
	}
	
	@BeforeAll
	public static void init() {
		inventory.put("01001", new Item("01001", "Apple", 1.1));
		inventory.put("01002", new Item("01002", "Banana", 1.6));
		inventory.put("01003", new Item("01003", "Carrot", 0.9));
		inventory.put("01004", new Item("01004", "Mango", 3.2));
		InventoryService.setInventory(inventory);
	}

	@Test
	void testAddItemToCart() {
		int expectedCount = 1;
		cartService.addToCart("01001");
		assertEquals(expectedCount, cartService.getItemsCount("01001"));
	}
	
	@Test
	void testBillingService() {
		Double expectedBill = 4.7;
		cartService.addToCart("01001");
		cartService.addToCart("01001");
		cartService.addToCart("01002");
		cartService.addToCart("01003");
		assertEquals(expectedBill, billingService.getTotalBillAmount(cartService.getCart()));
	}
	
	@Test
	void testTotalBillWhenCartIsEmpty()
	{
		Double expectedBill=0.0;
		assertEquals(expectedBill,billingService.getTotalBillAmount(cartService.getCart()));
	}

	@Test
	void testItemCountWhenCartIsEmpty() 
	{
		int expectedCount = 0;
		assertEquals(expectedCount, cartService.getItemsCount("01001"));
	}

	@Test
	void testPrintForLineItems() {
		String expectedPrint = "\n1 x Apple @1.1 = 1.1";
		String actualPrint = billingService.getFormattedLineItems(1, "Apple", 1.1,1.1);
		assertEquals(expectedPrint, actualPrint);
	}

	@Test
	void testPrintForTotalBill() {
		String expectedPrint = "\n\nTotal = 1.1";
		String actualPrint = billingService.getFormattedTotalAmount(1.1);
		assertEquals(expectedPrint, actualPrint);
	}

}

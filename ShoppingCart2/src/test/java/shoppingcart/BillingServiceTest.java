package shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shoppingcart.inventory.InventoryService;
import shoppingcart.inventory.Item;

class BillingServiceTest {

	private BillingService billingService;
	private InventoryService inventoryService;
	private PrintService printService;

	Map<String, Item> inventory;

	@BeforeEach
	void setUp() throws Exception {
		this.billingService = new BillingService();
		this.inventoryService = new InventoryService();
		this.printService = new PrintService(); 
		inventory = inventoryService.getItemsFromInventory();
	}

	@Test
	void testAddItemToCart() {
		int expectedCount = 1;

		billingService.addItemToCart("01001");
		assertEquals(expectedCount, billingService.getItemsCount("01001"));
	}

	@Test
	void testBillingService() {
		Double expectedBill = 4.7;
		billingService.addItemToCart("01001");
		billingService.addItemToCart("01001");
		billingService.addItemToCart("01002");
		billingService.addItemToCart("01003");
		assertEquals(expectedBill, billingService.getTotalBillingAmountOfCart(inventory));
	}

	@Test
	void testItemCountWhenCartIsEmpty()
	{
		int expectedCount = 0;
		assertEquals(expectedCount,billingService.getItemsCount("01001"));
	}
	
	@Test
	void testBillWhenTheCartIsEmpty()
	{
		Double expectedBill = 0.0;
		assertEquals(expectedBill,billingService.getTotalBillingAmountOfCart(inventory));
	}
	
	@Test
	void testPrintServiceForItems()
	{
		Object expectedPrint = "1 x Apple @1.1";
		Object actualPrint = printService.printBill(1,"Apple",1.1);
		assertEquals(expectedPrint,actualPrint);
	}
	
	@Test
	void testPrintServiceForTotalBill()
	{
		Object expectedPrint = "Total = 1.1";
		Object actualPrint = printService.printTotalBill(1.1);
	    assertEquals(expectedPrint,actualPrint);
	}
}

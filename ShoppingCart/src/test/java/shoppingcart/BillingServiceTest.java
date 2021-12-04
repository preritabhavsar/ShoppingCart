package shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillingServiceTest {

	private static BillingService billingService;
	
	@BeforeEach
	void setUp() throws Exception {
	   this.billingService=new BillingService();	
	}

	@Test
	void testAddItemToCart() {
		billingService.addItemToCart("01001");
		billingService.addItemToCart("01001");
		int count = billingService.getItemCount("01001");
		assertEquals(2,count);
	}
	
	@Test
	void testGetItemCount() {
		billingService.addItemToCart("01001");
		billingService.addItemToCart("01003");
		billingService.addItemToCart("01003");
	
		assertEquals(2,billingService.getItemCount("01003"));
	}

	@Test
	void testGetTotalBillAmount() {
		billingService.addItemToCart("01001");
		billingService.addItemToCart("01002");
		billingService.addItemToCart("01002");
		billingService.addItemToCart("01003");
        assertEquals(5.2, billingService.getTotalBillAmount());
	}
	
	@Test
	void testEmptyCartBill()
	{
		assertEquals(0.0,billingService.getTotalBillAmount());
	}
	
	@Test
	void testEmptyCart()
	{
		assertEquals(0,billingService.getItemCount("01001"));
	}
	

}

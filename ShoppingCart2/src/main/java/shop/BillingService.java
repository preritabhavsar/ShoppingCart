package shop;

import java.text.DecimalFormat;
import java.util.Map;

import inventory.InventoryService;
import inventory.Item;

public class BillingService {

	private static  DecimalFormat df = new DecimalFormat("0.0");
	private static final String BILL_PRINT_FORMAT = "\n%d" + " x " + "%s" + " @" + "%s" + " = " + "%s";
	public static final String TOTAL = "\n\nTotal" + " = " + "%s";

	public Double getTotalBillAmount(Map<String, Integer> cart) {

		Double totalBill = 0.0;

		for (Map.Entry<String,Integer> enrty : cart.entrySet()) {

			String barcode = (String) enrty.getKey();
			int quantity = (int) enrty.getValue();

			Item item = InventoryService.getItemByBarcode(barcode);
			totalBill += getBillAmountOfLineItem(totalBill, item, quantity);
			getFormattedLineItems(quantity, item.getName(), item.getPrice(),totalBill);

		}
		getFormattedTotalAmount(totalBill);
		return Double.parseDouble(df.format(totalBill));
	}

	private Double getBillAmountOfLineItem(Double totalBill, Item item, int quantity) {
		return item.getPrice() * quantity;
	}

	public String getFormattedLineItems(int quantity, String item, Double price,Double totalItemBill) {
		System.out.printf(BILL_PRINT_FORMAT, quantity, item, price,totalItemBill);
		String itemBillDescription = String.format(BILL_PRINT_FORMAT, quantity, item,df.format(price),df.format(totalItemBill));
		return itemBillDescription;
	}

	public String getFormattedTotalAmount(Double totalBill) {
		System.out.printf(TOTAL, totalBill);
		String totalBillDescription = String.format(TOTAL,df.format(totalBill));
		return totalBillDescription;
	}

}

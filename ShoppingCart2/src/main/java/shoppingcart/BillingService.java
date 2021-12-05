package shoppingcart;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import shoppingcart.inventory.Item;

public class BillingService {

	Map<String, Integer> itemsInCart = new HashMap<>();
	DecimalFormat df = new DecimalFormat("0.0");

	public void addItemToCart(String barcode) {
		if (!itemsInCart.containsKey(barcode)) {
			itemsInCart.put(barcode, 1);

		} else {

			itemsInCart.put(barcode, itemsInCart.get(barcode) + 1);
		}
	}

	public int getItemsCount(String barcode) {
		if (itemsInCart.isEmpty()) {
			return 0;
		}
		return itemsInCart.get(barcode);
	}

	public Double getTotalBillingAmountOfCart(Map<String, Item> cart) {
		Double totalBill = 0.0;
		PrintService printService = new PrintService();

		for (Map.Entry enrty : cart.entrySet()) {

			if (itemsInCart.containsKey(enrty.getKey())) {

				int count = (int) itemsInCart.get(enrty.getKey());
				Item cartItem = (Item) enrty.getValue();

				totalBill += cartItem.getPrice() * count;

				printService.printBill(count, cartItem.getName(), cartItem.getPrice());
			}

		}

		printService.printTotalBill(totalBill);
		return Double.parseDouble(df.format(totalBill));

	}

}

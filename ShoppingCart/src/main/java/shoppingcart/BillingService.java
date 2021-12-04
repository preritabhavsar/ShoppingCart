package shoppingcart;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BillingService implements BillIngInterface {

	Map<String, Integer> itemsInCart = new HashMap<>();

	DecimalFormat df = new DecimalFormat("0.0");

	@Override
	public void addItemToCart(String barcode) {
		if (!itemsInCart.containsKey(barcode)) {
			itemsInCart.put(barcode, 1);

		} else {
			itemsInCart.put(barcode, itemsInCart.get(barcode) + 1);
		}

	}

	@Override
	public int getItemCount(String barcode) {
		if (!itemsInCart.containsKey(barcode)) {
			return 0;
		}
		return itemsInCart.get(barcode);
	}

	@Override
	public Double getTotalBillAmount() {

		Double billAmount = 0.0;
		for (Map.Entry entry : itemsInCart.entrySet()) {
			
			String bar = (String) entry.getKey();
			int count = (int) entry.getValue();

			switch (bar) {
			case ("01001"):
				billAmount += Item.APPLE.getPrice() * count;
				break;
			case ("01002"):
				billAmount += Item.BANANA.getPrice() * count;
				break;
			case ("01003"):
				billAmount += Item.CARROT.getPrice() * count;
				break;
			}
		}

		return Double.parseDouble(df.format(billAmount));

	}

}

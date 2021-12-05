package shop;

import java.util.HashMap;
import java.util.Map;

public class CartService {

	private Map<String, Integer> cart = new HashMap<>();

	public void addToCart(String barcode) {

		if (!cart.containsKey(barcode)) {
			cart.put(barcode, 1);
		} else {
			cart.put(barcode, cart.get(barcode) + 1);
		}
	}

	public int getItemsCount(String barcode) {

		if (cart.isEmpty()) {
			return 0;
		}
		return cart.get(barcode);
	}

	public Map<String, Integer> getCart() {
		return cart;
	}
}

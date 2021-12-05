package inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

	private static Map<String,Item> inventory = new HashMap<>();

	public InventoryService() {}

	public static void setInventory(Map<String, Item> stock) {
		inventory = stock;
	}

	public static Map<String, Item> getItemsFromInventory() {
		return inventory;
	}

	public static Item getItemByBarcode(String barcode) {
		Item item = (Item) inventory.get(barcode);
		return item;
	}
}

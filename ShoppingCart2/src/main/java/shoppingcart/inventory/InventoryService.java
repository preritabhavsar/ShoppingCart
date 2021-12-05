package shoppingcart.inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

	Map<String,Item> inventory = new HashMap<>();

	public InventoryService() {
		  inventory.put("01001", new Item("01001","Apple",1.1));  
		  inventory.put("01002", new Item("01002","Banana",1.6));  
		  inventory.put("01003", new Item("01003","Carrot",0.9));  
	}
	
	public Map<String,Item> getItemsFromInventory()
	{
		return this.inventory;
	}
}

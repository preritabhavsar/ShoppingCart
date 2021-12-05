package inventory;

public class Item {
  
	private final String barcode;
	private final String name;
	private final Double price;
	
	public Item(String barcode, String name, Double price) {
		this.barcode = barcode;
		this.name = name;
		this.price = price;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
	
	
	
}

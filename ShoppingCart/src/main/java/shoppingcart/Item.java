package shoppingcart;

public enum Item {
  
	APPLE("Apple",1.1,"01001"),
	BANANA("Banana",1.6,"01002"),
	CARROT("Carrot",0.9,"01003");
	
	private final String label;
	private final Double price;
	private final String barcode;
	
	private Item(String label, Double price, String barcode) {
		this.label = label;
		this.price = price;
		this.barcode = barcode;
	}

	public String getLabel() {
		return label;
	}

	public Double getPrice() {
		return price;
	}

	public String getBarcode() {
		return barcode;
	}
	
	
	
	
    
	
}

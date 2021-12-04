package shoppingcart;

public interface BillIngInterface {
   
	void addItemToCart(String barcode);
	
	int getItemCount(String barcode);
	
	Double getTotalBillAmount();
}

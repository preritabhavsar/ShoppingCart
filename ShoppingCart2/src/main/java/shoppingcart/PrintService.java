package shoppingcart;

public class PrintService {

	public static final String BILL_PRINT_FORMAT = "\n%d" + " x " + "%s" + " @" + "%s";
	public static final String TOTAL = "\n\nTotal" + " = " + "%s";

	public String printBill(int quantity, String item, Double price) {
		System.out.printf(BILL_PRINT_FORMAT, quantity, item, price);
		String itemBillDescription = String.format(BILL_PRINT_FORMAT, quantity, item, String.valueOf(price));
		return itemBillDescription;
	}

	public String printTotalBill(Double totalBill) {
		System.out.printf(TOTAL, totalBill);
		String totalBillDescription = String.format(TOTAL, String.valueOf(totalBill));
		return totalBillDescription;
	}
}

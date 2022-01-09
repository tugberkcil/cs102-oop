
public class Main {

	public static void main(String[] args) {
    AppleStore Store = new AppleStore();
		
		Store.setStoreName("Akasya");
		System.out.println(Store.toString());
		Store.setExchangeRate(8);
		Store.printStoreFinancial();
		Store.sellMacs(10);
		Store.sellMacs(5);
	}

}

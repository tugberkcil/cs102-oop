
public class AppleStore {
	private String storeName;
	private double exchangeRate;
	private double macCost;
	private double macPrice;
	private int soldMacCount;
	
	AppleStore(){
		exchangeRate= 7.5;
		macPrice= 1500;
		macCost = 1300;
		soldMacCount= 0;
	}

	
	public void setStoreName(String storeName) {
    	this.storeName= storeName;
    }
	  public double getExchangeRate() {
	    	exchangeRate=7.6;
	    	return exchangeRate;
	    }
	  public void sellMacs(int soldAmount) {
	    	soldMacCount+=soldAmount;
	    	System.out.println(soldMacCount +" macs sold. ");
	  }
	  public void setExchangeRate(double rate) {
	    	exchangeRate= rate;
	    	System.out.println("The exchange rate has been changed!");
	    	System.out.println("The exchange rate: 1 USD = " + exchangeRate + " TL");

	    }
	  public double getRevenue() {
	    	return soldMacCount*exchangeRate*macPrice;
	    }
	  public double getProfit() {
	    	return soldMacCount*(macPrice-macCost)*exchangeRate;
	    }
	  public String toString() {
	    	return "Apple Store Name: " + storeName + " \n the cost of a Macbook: " + macCost + " USD \n the price of a Macbook: " + macPrice + " USD \n the exchange rate : 1 USD" +exchangeRate;
	    }
	  public void printStoreFinancial() {
	    	System.out.println("Total revenue of macs sold:" + soldMacCount );
	    	System.out.println("Total revenue: " + getRevenue());
	    	System.out.println("Total profit: " + getProfit());

	    }






}


public class CreditCard {

	private long creditCardNumber;
	private int cvv, mm, yy;
	private String user, type, additionalUser;
	private double creditLimit, creditBalance, rate, pastDue;
	
	public CreditCard() {		
		this.creditCardNumber = 0L;
		this.cvv = 0;
		this.mm = 1;
		this.yy = 2000;
		this.user = "";
		this.type = "";
		this.creditLimit = 500;		//Minimum Credit Limit
		this.creditBalance = 0;		//Default	
	}
	
	public CreditCard(long creditCardNumber, int cvv, int mm, int yy, String user, String type, double creditLimit, double creditBalance, double rate) {		
		this.creditCardNumber = creditCardNumber;
		this.cvv = cvv;
		this.mm = mm;
		this.yy = yy;
		this.user = user;
		this.type = type;
		this.creditLimit = creditLimit;
		this.creditBalance = creditBalance;
	}
	
	//SETTERS
	public void setCreditCardNumber(long num) {
		if (num < 1000000000000000L || num > 9999999999999999L) {
	        throw new IllegalArgumentException();
	    }
		this.creditCardNumber = num;
	}
	
	public void setCVV(int num) {
		if (num > 999) {
	        throw new IllegalArgumentException();
	    }
		this.cvv = num;
	}
	
	public void setMM(int mm) {
		if (mm < 1 || mm > 12) {
	        throw new IllegalArgumentException();
	    }
		this.mm = mm;
	}
	
	public void setYY(int yy) {
		if (yy < 2020 || yy > 2024) {
	        throw new IllegalArgumentException();
	    }
		this.yy = yy;
	}
	
	public void setUser(String name) {
		this.user = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setAdditionalUser(String name) {
		this.additionalUser = name;
	}
	
	public void setCreditLimit(double limit) {
		this.creditLimit = limit;
	}
	
	public void setCreditBalance(double bal) {
		this.creditBalance = bal;
	}
	
	public void setRate(double apr) {
		this.rate = apr;
	}
	
	public void setPastDue(double amt) {
		this.pastDue = amt;
	}
	
	//GETTERS
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public int getCVV() {
		return cvv;
	}
	
	public int getMM() {
		//
		return mm;
	}
	
	public int getYY() {
		return yy;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getType() {
		return type;
	}
	
	public String getAdditionalUser() {
		return additionalUser;
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}
	
	public double getCreditBalance() {
		return creditBalance;
	}
	
	public double getRate() {
		return rate;
	}	
	
	public double getPastDue() {
		return pastDue;
	}
	
	//Methods
	public double getMinumumMonthlyPayment() {
		double financeCharge = (rate/12) * creditBalance;
		double portionOfBalance = creditBalance * .015;
		return financeCharge + portionOfBalance;
	}
	
	public void makePayment(double payment) {
		double amountDue = this.getMinumumMonthlyPayment();
		if(payment >= amountDue) {
			payment -= amountDue;
			this.creditBalance -= payment;
		}else {
			amountDue -= payment;
			this.setPastDue(amountDue);
		}
	}
	
}

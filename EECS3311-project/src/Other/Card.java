package Other;

public class Card {
	long cardNum;
	int expMonth, expYear, CVV;
	String first, last;
	
	
	public Card(long num, int month, int year, int cvv, String first, String last) {
		this.cardNum = num;
		this.expMonth = month;
		this.expYear = year;
		this.CVV = cvv;
		this.first = first;
		this.last = last;
	}


	public long getCardNum() {
		return cardNum;
	}


	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}


	public int getExpMonth() {
		return expMonth;
	}


	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}


	public int getExpYear() {
		return expYear;
	}


	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}


	public int getCVV() {
		return CVV;
	}


	public void setCVV(int cVV) {
		CVV = cVV;
	}


	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}
	
	public String toString ()
	{
		String str = "";
		
		str = str + this.getCardNum() +","+this.getExpMonth()+","+this.getExpYear()+","+this.getCVV()+","
				+this.getFirst()+","+this.getLast();
		return str;
	}
	
	

}

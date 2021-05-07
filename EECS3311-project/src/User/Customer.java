package User;

import java.util.ArrayList;

import Other.ParkingSpot;

public class Customer extends User {
	//TODO Declare spots reserved and payment
	
	ArrayList<String> spotsReserved;
	
	
	public Customer(String first, String last, String email, String pass) {
		
		super (first, last, email, pass);
		spotsReserved = new ArrayList<String>();
		
	}
	public Customer(String first, String last, String email, String pass, ArrayList<String> spots) {
		
		super (first, last, email, pass);
		spotsReserved = spots;
		
	}
	public void removeBooking (String bookingId)
	{
		for (int i = 0; i < spotsReserved.size(); i ++)
		{
			if (spotsReserved.get(i).equals(bookingId))
			{
				spotsReserved.remove(i);
			}
		}
	}
	
	public boolean spotsFilled ()
	{
		if (spotsReserved.size() == 3)
		{
			return true;
		}
		return false;
	}
	
	
	public String toString ()
	{
		String str;
		str = this.getFirstName()+","+this.getLastName()+","+this.getEmail()+","+this.getPassword();
		
		for (int i = 0; i < spotsReserved.size(); i++)
		{
		
				str = str+","+spotsReserved.get(i);
		
		}
		return str;
	}
	public ArrayList<String> getSpotsReserved() {
		return spotsReserved;
	}
	public void setSpotsReserved(ArrayList<String> spotsReserved) {
		this.spotsReserved = spotsReserved;
	}

}

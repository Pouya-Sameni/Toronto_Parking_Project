package User;

import java.time.LocalTime;

public class ParkingEnforcer extends User{

	String id;
	public ParkingEnforcer(String first, String last, String email, String pass) {
		super (first, last, email, pass);
		this.id = idGen();
	}
	public ParkingEnforcer(String first, String last, String email, String pass, String id) {
		super (first, last, email, pass);
		this.id = id;
	}
	
	public String idGen ()
	{
		return (this.getFirstName().charAt(0)+""+this.getLastName().charAt(0)+""+LocalTime.now().getNano()+"");
	}
	
	public String toString ()
	{
		String str;
		
		str = this.getFirstName()+","+this.getLastName()+","+this.getEmail()+","+this.getPassword()+","+this.id;
		
		return str;
	}
}

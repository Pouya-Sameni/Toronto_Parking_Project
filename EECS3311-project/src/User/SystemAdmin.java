package User;

public class SystemAdmin extends User {


	public SystemAdmin(String first, String last, String email, String pass) {
		super (first, last, email, pass);
		
		
	}
	
	
	public String toString ()
	{
		String str;
		
		str = this.getFirstName()+","+this.getLastName()+","+this.getEmail()+","+this.getPassword();
		
		return str;
	}


}

package User;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User (String first, String last, String email, String pass)
	{
		firstName = first;
		lastName = last;
		this.email = email;
		this.password = pass;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean checkPass (String pass)
	{
		return pass.equals(this.getPassword());
	}
	
	
	

}

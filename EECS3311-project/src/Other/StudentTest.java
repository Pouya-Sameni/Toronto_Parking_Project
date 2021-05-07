package Other;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Accounts.AdminPage;
import Accounts.CustomerPage;
import Accounts.EnforcerPage;
import Other.Bookings;
import Other.Card;
import Other.DataBase;
import Other.ParkingSpot;
import User.Customer;
import User.ParkingEnforcer;
import User.SystemAdmin;
import User.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class StudentTest {
 /**
  * TODO: Please write at least 5 test cases for testing @BubbleSort.
  * TODO: Please write at least 5 test cases for testing @HeapSort.
  */
	Customer cus;
	ParkingEnforcer officer;
	
	CustomerPage cusPage;
	EnforcerPage officerPage;
	AdminPage adminPage;
	
	@Before
    public void setUp() throws Exception {
		DataBase db = new DataBase();
		
		cus = new Customer ("Pouya", "Sameni", "pouya@york", "pass");
		officer = new ParkingEnforcer ("John", "Doe", "john@city", "pass");
		
		cusPage = new CustomerPage (cus, db);
		officerPage = new EnforcerPage (officer, db);
		adminPage = new AdminPage (db);
		
		
    }
	
	@Test
    public void AddRemoveOfficer1() {
		ParkingEnforcer newOfficer = new ParkingEnforcer ("Jane", "Doe", "jane@city", "pass");
		
		Assert.assertEquals(adminPage.addOfficer(newOfficer), true);
		Assert.assertEquals(adminPage.removeOfficer(newOfficer.getEmail()), true);

	} 
	
	@Test
    public void AddRemoveOfficer2() {

		Assert.assertEquals(adminPage.removeOfficer("I dont exist"), false);

	} 


}

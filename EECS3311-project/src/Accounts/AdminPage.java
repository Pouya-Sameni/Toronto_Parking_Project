package Accounts;

import Other.DataBase;
import User.ParkingEnforcer;
import User.SystemAdmin;

public class AdminPage {

	DataBase db;

	
	
	public AdminPage (DataBase data) {
		// TODO Auto-generated constructor stub
		
		this.db = data;
	
	}
	
	public boolean addOfficer(ParkingEnforcer officer)
	{
		for (int i = 0; i < db.getOfficers().size(); i ++)
		{
			if (db.getOfficers().get(i).getEmail().equals(officer.getEmail()) &&
					db.getOfficers().get(i).getPassword().equals(officer.getPassword()))
			{
				return false;
			}
			
			
		}
		
		db.getOfficers().add(officer);
		db.writeAll();
		
		return true;
		
	}
	
	public boolean removeOfficer(String officerEmail)
	{
		for (int i = 0; i < db.getOfficers().size();i++)
		{
			if (db.getOfficers().get(i).getEmail().equals(officerEmail))
			{
				db.getOfficers().remove(i);
				db.writeAll();
				return true;
			}
		}
		
		db.writeAll();
		return false;
	}

	
	
}

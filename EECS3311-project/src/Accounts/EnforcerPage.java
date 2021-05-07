package Accounts;

import Other.DataBase;
import Other.ParkingSpot;
import User.ParkingEnforcer;

public class EnforcerPage {

	DataBase data;
	ParkingEnforcer officer;
	
	public EnforcerPage(ParkingEnforcer officer, DataBase data) {
		this.data = data;
		this.officer = officer;
	}
	
	public boolean addParkingSpot (int spotId)
	{
		ParkingSpot temp = new ParkingSpot (spotId);
		
		for (int i = 0; i < data.getCitySpots().size(); i ++)
		{
			if (data.getCitySpots().get(i).getSpotId() == spotId)
			{
				return false;
			}
		}
		
		data.getCitySpots().add(temp);
		data.writeAll();
		return true;
		
	}
	
	public boolean removeParkingSpot (int spotId)
	{
		for (int i = 0; i < data.getCitySpots().size(); i ++)
		{
			if (data.getCitySpots().get(i).getSpotId() == spotId)
			{
				if (data.getCitySpots().get(i).getBookingId().isEmpty() && data.getCitySpots().size() > 1)
				{
					data.getCitySpots().remove(i);
					
					return true;
				}
				
			}
		}
		
		return false;
	}
	
	public boolean cancelRequest ()
	{
		//TODO cancel the request of customer for parking specified
		return false;
	}
	
	public boolean grantRequest ()
	{
		//TODO grant the request of customer for parking specified
		return false;
	}
	
	public ParkingSpot spotDetail (int spot)
	{
		//Return the parking spot that matches the one specified
		return null;
	}
	
	

}

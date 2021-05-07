package Other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import User.Customer;
import User.ParkingEnforcer;
import User.SystemAdmin;
import User.User;

public class DataBase {
	private SystemAdmin admin;
	private ArrayList<ParkingSpot> citySpots;
	private ArrayList<Customer> customers;
	private ArrayList<ParkingEnforcer> officers;
	private ArrayList<Bookings> bookings;
	private ArrayList<Card> payments;
	
	public DataBase() {
		citySpots = new ArrayList<ParkingSpot>();
		customers = new ArrayList<Customer>();
		officers = new ArrayList<ParkingEnforcer>();
		bookings = new ArrayList<Bookings>();
		payments =  new ArrayList<Card>();
		readAll();
	}
	
	public void readAll ()
	{
		readCus ();
		readAdmin ();
		readEnforcer();
		readParkingSpots();
		readPayments();
		readBookings();
		removeExpired();
		writeAll();
	}
	
	public void writeAll ()
	{
		removeExpired();
		writeCus();
		writeSpot ();
		writeOfficers ();
		writeBookings ();
		writePayments ();
	}
	
	
	//=================================================================================
	//Read File Methods
	
	public void readCus ()
	{
		try {
			File cusAccts = new File("src/DataBaseFiles/customerAccounts.txt");
			Scanner sc = new Scanner(cusAccts);
			Customer cus;
			String str;
			String [] delimited;
			ArrayList<String> spots=new ArrayList<String>();
			
		    while (sc.hasNextLine())
		    {
		    	spots=new ArrayList<String>();
		    	str = sc.nextLine();
		    	
		    	delimited = str.split(",");
		    	if (delimited.length <= 4)
		    	{
		    		cus = new Customer (delimited[0], delimited[1], delimited[2], delimited[3]);
		    	}
		    	else
		    	{
		    		 
		    		for (int i = 4; i < delimited.length; i ++)
		    		{
		    			 spots.add(delimited[i]);
		    		}
		    		
		    		
		    		
		    		cus = new Customer (delimited[0], delimited[1], delimited[2], delimited[3], spots);
		    		
		    	}
		    	
		    	
		    	
		    	customers.add(cus);
		    	
		    }
		    
		    sc.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Customer Accounts File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("File Could not be opened");
		}
	}

	public void readAdmin ()
	{
		try {
			File adminAccts = new File("src/DataBaseFiles/adminAccounts.txt");
			Scanner sc = new Scanner(adminAccts);
		
			String str;
			String [] delimited;
			
			
		    while (sc.hasNextLine())
		    {
		    	str = sc.nextLine();
		    	
		    	delimited = str.split(",");
		    	this.admin = new SystemAdmin (delimited[0], delimited[1], delimited[2], delimited[3]);
		    	
		    }
		    sc.close();
		    
		} catch (FileNotFoundException e) {
			System.out.println ("System Admin Accounts File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("File Could not be opened");
		}
	}
	
	public void readEnforcer ()
	{
		try {
			File officerAccts = new File("src/DataBaseFiles/officerAccounts.txt");
			Scanner sc = new Scanner(officerAccts);
			ParkingEnforcer officer;
			String str;
			String [] delimited;
			
			
		    while (sc.hasNextLine())
		    {
		    	str = sc.nextLine();
		    	
		    	delimited = str.split(",");
		    	officer = new ParkingEnforcer 
		    			(delimited[0], delimited[1], delimited[2], delimited[3], delimited[4]);
		    	officers.add(officer);
		    }
		    sc.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Parking Enforcer Accounts File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("File Could not be opened");
		}
	}

	public void readParkingSpots ()
	{
		try {
			File parkingSpots = new File("src/DataBaseFiles/parkingSpots.txt");
			Scanner sc = new Scanner(parkingSpots);
			ParkingSpot spot;
			String str;
			String [] delimited;
			
			
		    while (sc.hasNextLine())
		    {
		    	str = sc.nextLine();
		    	
		    	delimited = str.split(",");
		    	
		    	if (delimited.length > 1)
		    	{
		    		spot = new ParkingSpot (Integer.parseInt(delimited[0]), delimited[1]);
		    	}
		    	else
		    	{
		    		spot = new ParkingSpot (Integer.parseInt(delimited[0]));
		    	}
		    	
		    	citySpots.add(spot);
		    }
		    sc.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Parking Enforcer Accounts File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("File Could not be opened");
		}
	}
	
	public void readBookings ()
	{
		try {
			File bookings = new File("src/DataBaseFiles/bookingDetails.txt");
			Scanner sc = new Scanner(bookings);
			Bookings booking;
			String str;
			String [] delimited;
			
			
		    while (sc.hasNextLine())
		    {
		    	str = sc.nextLine();
		    	
		    	delimited = str.split(",");
		    	
		    	if(Boolean.parseBoolean(delimited[3]))
		    	{
		    		booking  = new Bookings(findCustomer(delimited[0]), findSpot(delimited[0]), delimited[1],
		    				 delimited[0],Long.parseLong(delimited[2]),Boolean.parseBoolean(delimited[3]),
		    				 Boolean.parseBoolean(delimited[4]),LocalDateTime.parse(delimited[5]),
		    				 LocalDateTime.parse(delimited[6]),findPayment(Long.parseLong(delimited[7])),Boolean.parseBoolean(delimited[8]));
		    	}
		    	else
		    	{
		    		booking = new Bookings (findCustomer(delimited[0]), findSpot(delimited[0]), delimited[0],
		    				delimited[1], Long.parseLong(delimited[2]), Boolean.parseBoolean(delimited[3]),
		    				Boolean.parseBoolean(delimited[4]), Boolean.parseBoolean(delimited[5]));
		    	}
		    	
		    	this.bookings.add(booking);
		    	
		    }
		    sc.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Parking Enforcer Accounts File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("File Could not be opened");
		}
	}
	
	public void readPayments ()
	{
		try {
			File parkingSpots = new File("src/DataBaseFiles/payments.txt");
			Scanner sc = new Scanner(parkingSpots);
			Card card;
			String str;
			String [] delimited;
			
			
		    while (sc.hasNextLine())
		    {
		    	str = sc.nextLine();
		    	
		    	delimited = str.split(",");
		    	
		    	card = new Card (Long.parseLong(delimited[0]), Integer.parseInt(delimited[1]), Integer.parseInt(delimited[2]), 
		    			Integer.parseInt(delimited[3]),delimited[4], delimited[5]);
		    	
		    	payments.add(card);
		    }
		    sc.close();
		} catch (FileNotFoundException e) {
			System.out.println ("Parking Enforcer Accounts File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("File Could not be opened");
		}
	}
	
	//Read File Methods
	//=================================================================================
	
		
	
	//=================================================================================
	//Write File Methods
	
	public void writeCus ()
	{
		try {
			FileWriter writer = new FileWriter("src/DataBaseFiles/customerAccounts.txt");
			
			for (int i = 0; i < customers.size(); i ++)
			{
				writer.write(customers.get(i).toString()+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeSpot ()
	{
		
		try {
			FileWriter writer = new FileWriter("src/DataBaseFiles/parkingSpots.txt");
			
			for (int i = 0; i < citySpots.size(); i ++)
			{
				writer.write(citySpots.get(i).toString()+"\n");
			}
			writer.close();
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeOfficers ()
	{
		
		try {
			FileWriter writer = new FileWriter("src/DataBaseFiles/officerAccounts.txt");
			
			for (int i = 0; i < officers.size(); i ++)
			{
				writer.write(officers.get(i).toString()+"\n");
			}
			writer.close();
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeBookings ()
	{
	
		try {
			FileWriter writer = new FileWriter("src/DataBaseFiles/bookingDetails.txt");
			
			for (int i = 0; i < bookings.size(); i ++)
			{
				writer.write(bookings.get(i).toString()+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePayments ()
	{
	
		try {
			FileWriter writer = new FileWriter("src/DataBaseFiles/payments.txt");
			
			for (int i = 0; i < payments.size(); i ++)
			{
				writer.write(payments.get(i).toString()+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Write File Methods
	//=================================================================================

	
	public boolean addCustomer(Customer cus)
	{
		//TODO Add customer to the data base
		for (int i = 0; i < customers.size(); i ++)
		{
			if (customers.get(i).getEmail().equals(cus.getEmail()) &&
					customers.get(i).getPassword().equals(cus.getPassword()))
			{
				return false;
			}

		}
		
		customers.add(cus);
		writeAll();
		
		return true;
	}
	
	public void removeExpired ()
	{
		String id;
		for (int i = 0; i < bookings.size(); i ++)
		{
			if (bookings.get(i).getExpTime() != null)
			{
				if (bookings.get(i).getExpTime().isBefore(LocalDateTime.now()))
				{
					id = bookings.get(i).getBookingId();
					this.findSpot(id).setBookingId("");
					this.findCustomer(id).removeBooking(id);
					bookings.remove(i);
				}
			}
		}
	}
	
	public Card findPayment (long cardNum)
	{
		for (int i = 0; i < payments.size(); i ++)
		{
			for (int j = 0; j < payments.size(); j ++)
			{
				if (payments.get(i).getCardNum() == cardNum)
				{
					return payments.get(i);
				}
			}
		}
		return null;
	}
	
	public Customer findCustomer (String bookingID)
	{
		if (bookingID == null)
		{
			return null;
		}
		for (int i = 0; i < customers.size(); i ++)
		{
			for (int j = 0; j < customers.get(i).getSpotsReserved().size(); j ++)
			{
				if (customers.get(i).getSpotsReserved().get(j).equals(bookingID))
				{
					return customers.get(i);
				}
			}
		}
		return null;
	}
	
	public Bookings findBooking (int spotId)
	{
		for (int i = 0; i < bookings.size(); i ++)
		{
			if (bookings.get(i).getSpot().getSpotId() == spotId)
			{
				return bookings.get(i);
			}
		}
		
		return null;
	}
	
	public Bookings findBooking (String bookingId)
	{
		for (int i = 0; i < bookings.size(); i ++)
		{
			if (bookings.get(i).getBookingId().equals(bookingId))
			{
				return bookings.get(i);
			}
		}
		
		return null;
	}
	
	public ParkingSpot findSpot (String bookingID)
	{
		if (bookingID == null)
		{
			return null;
		}
		for (int i = 0; i < citySpots.size(); i ++)
		{
			for (int j = 0; j < 3; j ++)
			{
				if (citySpots.get(i).getBookingId().equals(bookingID))
				{
					return citySpots.get(i);
				}
			}
		}
		return null;
	}
	
	public ParkingSpot findSpot (int spotId)
	{
		
		for (int i = 0; i < citySpots.size(); i ++)
		{
				if (citySpots.get(i).getSpotId() == spotId)
				{
					return citySpots.get(i);
				}
		}
		return null;
	}
	
	public void clearBooking (Bookings booking)
	{
		for (int i = 0; i < bookings.size(); i ++)
		{
			if (booking.getBookingId().equals(bookings.get(i).getBookingId()))
			{
				bookings.remove(i);
			}
		}
		
		for (int i = 0; i < citySpots.size(); i ++)
		{
			if (booking.getBookingId().equals(citySpots.get(i).getBookingId()))
			{
				citySpots.get(i).setBookingId("");
			}
		}
		
		for (int i = 0; i < customers.size(); i ++)
		{
			for (int j = 0; j < customers.get(i).getSpotsReserved().size(); j ++)
			{
				if (booking.getBookingId().equals(customers.get(i).getSpotsReserved().get(j)))
				{
					customers.get(i).removeBooking(booking.getBookingId());
				}
			}
		}
		
		writeAll();
	}
	

	
	public User signIn (String user, String password)
	{
		for (int i = 0; i < customers.size(); i ++)
		{
			if (customers.get(i).getEmail().equals(user) && customers.get(i).getPassword().equals(password))
			{
				return customers.get(i);
			}
		}
		for (int i = 0; i < officers.size(); i ++)
		{
			if (officers.get(i).getEmail().equals(user) && officers.get(i).getPassword().equals(password))
			{
				return officers.get(i);
			}
		}
		if (admin.getEmail().equals(user) && admin.getPassword().equals(password))
		{
			return admin;
		}
		
		return null;
	}

	public SystemAdmin getAdmin() {
		return admin;
	}

	public ArrayList<ParkingSpot> getCitySpots() {
		return citySpots;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public ArrayList<ParkingEnforcer> getOfficers() {
		return officers;
	}

	public ArrayList<Bookings> getBookings() {
		return bookings;
	}

	public ArrayList<Card> getPayments() {
		return payments;
	}
	
	

}

package Accounts;

import java.time.LocalDateTime;
import java.time.LocalTime;

import Other.Bookings;
import Other.Card;
import Other.DataBase;
import Other.ParkingSpot;
import User.Customer;

public class CustomerPage {
	private Customer customer;
	private DataBase data;
	
	public CustomerPage(Customer customer, DataBase data) {
		this.customer = customer;
		this.data = data;
	}
	
	public Bookings bookSpot (int spot,String license, long time)
	{
		
		if (customer.spotsFilled() || data.findBooking(spot) != null)
		{
			return null;
		}
		Bookings booking = new Bookings (customer,data.findSpot(spot),license, time);
		customer.getSpotsReserved().add(booking.getBookingId());
		booking.getSpot().setBookingId(booking.getBookingId());
		data.getBookings().add(booking);
		data.writeAll();
		
		return booking ;
		
	}
	
	public Bookings getBooking (String bookingId)
	{
		
		return data.findBooking(bookingId);
	}
	
	public boolean cancelBooking (String bookingId)
	{
		int index = data.getBookings().indexOf(data.findBooking(bookingId));
		if (!bookingId.isEmpty() && bookingId!=null)
		{
			
			if (index != -1)
			{
			
				if (data.getBookings().get(index).isPaid() && data.getBookings().get(index).getExpTime().isAfter(LocalDateTime.now()))
				{
					
					data.getBookings().remove(index);
					data.findSpot(bookingId).setBookingId("");
					customer.getSpotsReserved().remove(bookingId);
				}
				else if (!data.getBookings().get(index).isPaid())
				{
					
					data.getBookings().remove(index);
					data.findSpot(bookingId).setBookingId("");
					customer.getSpotsReserved().remove(bookingId);
				}
				else
				{
				
					return false;
				}
				data.writeAll();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addPayment (Card card)
	{
		//TODO add payment to their list
		return false;
	}
	public boolean paySpot (Card payment, String bookingId)
	{
		
		if (!payment.getFirst().equals(customer.getFirstName()) && !payment.getLast().equals(customer.getLastName()))
				{
					return false;
				}
		data.findBooking(bookingId).hasPaid(payment);
		for (int i = 0; i <data.getPayments().size(); i++ )
		{
			if (data.getPayments().get(i).getCardNum() == payment.getCardNum())
			{
				return true;
			}
			
		}
		data.getPayments().add(payment);
		data.writeAll();
		return true;
		
	}
	public ParkingSpot[] viewBookings ()
	{
		return null;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DataBase getData() {
		return data;
	}

	public void setData(DataBase data) {
		this.data = data;
	}
	

}

package Other;

import java.time.LocalDateTime;
import java.time.LocalTime;

import User.Customer;

public class Bookings {
	private Customer customer;
	private ParkingSpot spot;
	private String bookingId;
	private String license;
	private long duration;
	private LocalDateTime confTime;
	private LocalDateTime expTime;

	private boolean paid;
	private boolean approved;
	private boolean granted;
	private Card payment;

	public Bookings(Customer cus, ParkingSpot spot, String license, long duration) {
		this.customer = cus;
		this.spot = spot;
		this.license = license;
		paid = false;
		approved = false;
		this.granted = false;
		this.duration = duration;
		this.bookingId = idGen();
		this.confTime = null;
		this.expTime = null;
		this.payment=null;
		
	}
	
	public Bookings(Customer cus, ParkingSpot spot, String id, String license, 
			long duration, Boolean paid, Boolean approved, Boolean granted) {
		this.customer = cus;
		this.spot = spot;
		this.license = license;
		this.paid = paid;
		this.approved = approved;
		this.granted = granted;
		this.duration = duration;
		this.bookingId = id;
		this.confTime = null;
		this.expTime = null;
		this.payment=null;

	}
	

	
	public Bookings(Customer cus, ParkingSpot spot, String license, String id,long duration,
			boolean paid, boolean approved, LocalDateTime confTime, LocalDateTime expTime, Card payment, boolean granted)
	{
		this.customer = cus;
		this.spot = spot;
		this.duration = duration;
		this.bookingId = id;
		this.license = license;
		this.confTime = confTime;
		this.expTime = expTime;
		this.paid = paid;
		this.approved = approved;
		this.granted = granted;
		this.payment = payment;
	}

	public void hasPaid (Card payment)
	{
		this.payment = payment;
		this.paid = true;
		this.confTime = LocalDateTime.now();
		this.expTime = this.confTime.plusMinutes(duration);
	}
	
	public String idGen ()
	{
		return (this.license.charAt(0)+""+this.license.charAt(0)+""+LocalTime.now().getNano()+"");
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ParkingSpot getSpot() {
		return spot;
	}

	public void setSpot(ParkingSpot spot) {
		this.spot = spot;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}


	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	
	public String toString ()
	{
		String str;
		
		str = ""+this.bookingId+","+this.license+","+this.duration+","+this.paid+","+this.approved+"";
		
		if (paid)
		{
			str = str +","+this.confTime.toString()+","+this.expTime.toString() + "," + this.getPayment().getCardNum();
		}
		str = str + ","+this.granted;
		return str;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public LocalDateTime getConfTime() {
		return confTime;
	}

	public void setConfTime(LocalDateTime confTime) {
		this.confTime = confTime;
	}

	public LocalDateTime getExpTime() {
		return expTime;
	}

	public void setExpTime(LocalDateTime expTime) {
		this.expTime = expTime;
	}

	public Card getPayment() {
		return payment;
	}

	public void setPayment(Card payment) {
		this.payment = payment;
	}

	public boolean isGranted() {
		return granted;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}

	
}

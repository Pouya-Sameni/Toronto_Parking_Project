package Other;

public class ParkingSpot {
	private int spotId;
	private String bookingId;

	public ParkingSpot(int id, String book) {
		this.spotId = id;
		this.bookingId = book;

	}
	
	public ParkingSpot (int id)
	{
		this.spotId = id;
		this.bookingId = "";
	}



	public int getSpotId() {
		return spotId;
	}

	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	public String toString ()
	{
		String str;
		if (this.bookingId.isEmpty())
		{
			str = ""+this.spotId;
		}
		else
		{
			str = this.spotId+","+this.bookingId;
		}
		
		return str;
	}
}

package Hotel;

public class Hotel {

	private String HotelName;
	private int Weekday;
	private int Weekend;
	
	
	public Hotel(String HotelName, int Weekday, int Weekend) {
		this.HotelName = HotelName;
		this.Weekday = Weekday;
		this.Weekend = Weekend;
	}
	
	public String getHotelName() {
		return HotelName;
	}
	
	public int getWeekday() {
		return Weekday;
	}
	
	public int getWeekend() {
		return Weekend;
	}
	
	@Override
	public String toString() {
		return "Hotel Name= " + HotelName + "\n Weekday Rate = " +Weekday+ "\n Weekend Rate ="+ Weekend;
	}
	
}

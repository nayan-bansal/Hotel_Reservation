package Hotel;

public class Hotel {

	private String HotelName;
	private int Weekday;
	private int Weekend;
	private long total_amount;
	
	public Hotel(String HotelName, int Weekday, int Weekend) {
		this.HotelName = HotelName;
		this.Weekday = Weekday;
		this.Weekend = Weekend;
	}
	
	public String getHotelName() {
		return HotelName;
	}
	
	public void  setTotalPrice(long total_amount) {
		this.total_amount = total_amount;
	}
	
	public long getTotalPrice() {
		return total_amount;
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
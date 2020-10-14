package Hotel;

public class Hotel {

	private String HotelName;
	private int Weekday;
	private int Weekend;
	private long total_amount;
	private int HotelRating;
	private int SpecialWeekday;
	private int SpecialWeekend;
	
	public Hotel(String HotelName, int Weekday, int Weekend, int HotelRating, int SpecialWeekday, int SpecialWeekend) {
		this.HotelName = HotelName;
		this.Weekday = Weekday;
		this.Weekend = Weekend;
		this.HotelRating = HotelRating;
		this.SpecialWeekday = SpecialWeekday;
		this.SpecialWeekend = SpecialWeekend;
	}
	
	public int getSpecialWeekday() {
		return SpecialWeekday ;
	}
	
	public int getSpecialWeekend() {
		return SpecialWeekend;
	}
	
	public String getHotelName() {
		return HotelName;
	}
	
	public void  setTotalPrice_weekdays(long total_amount) {
		this.total_amount = total_amount;
	}
	
	public long getTotalPrice_weekdays() {
		return total_amount;
	}

	public void  setTotalPrice_weekend(long total_amount) {
		this.total_amount = total_amount;
	}
	
	public long getTotalPrice_weekend() {
		return total_amount;
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
	
	public int getHotelRating() {
		return HotelRating;
	}
	
	@Override
	public String toString() {
		return "Hotel Name= " + HotelName + "\n Weekday Rate = " +Weekday+ "\n Weekend Rate ="+ Weekend;
	}
	
}
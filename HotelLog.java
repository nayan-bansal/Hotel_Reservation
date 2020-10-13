package Hotel;

import java.util.ArrayList;

public class HotelLog {

	private ArrayList<Hotel> hotelbook = new ArrayList<>();
	
	
	public void setHotelBook(ArrayList<Hotel> hotelbook) {
		this.hotelbook = hotelbook; 
	}
	
	public ArrayList<Hotel> getHotelBook(){
		return hotelbook;
	}
	
	public void addHotelBook(Hotel hotel) {
		
		hotelbook.add(hotel);
	}
	
	public void printHotel() {
			for(Hotel hotel : hotelbook)
			System.out.println(hotel);
	}

	
}

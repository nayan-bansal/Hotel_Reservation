package Hotel;

public class Hotel_Reservation_Main {

	private static void addHotelRegularPrice() {
		
		//Adding The List of Hotels
		HotelLog log = new HotelLog();
		
		Hotel LakeWood = new Hotel("LakeWood", 110, 90);
		log.addHotelBook(LakeWood);
		
		Hotel BridgeWood = new Hotel("BridgeWood", 160, 60);
		log.addHotelBook(BridgeWood);
		
		Hotel RidgeWood = new Hotel("RidgeWood", 220, 150);
		log.addHotelBook(RidgeWood);
		
		//Printing Hotel List and Rates
		log.printHotel();
		
	}
	
	
	
	public static void main(String[] args) {
		
		//UC_1: Welcome Message
		
		System.out.println("Welcome to Hotel Reservation System!!");
		
		//UC_2: Adding Hotel to the Log Book and Printing Hotel Name with Rates for Weekend and Weekdays
		addHotelRegularPrice();
	
	
	}

	
}

package Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Hotel_Reservation_Main {

	private static final Scanner scan = new Scanner(System.in);
	static HotelLog log = new HotelLog();
	
	private static void addHotelRegularPrice() {
		
		//Adding The List of Hotels
		
		Hotel LakeWood = new Hotel("LakeWood", 110, 90);
		log.addHotelBook(LakeWood);
		
		Hotel BridgeWood = new Hotel("BridgeWood", 160, 60);
		log.addHotelBook(BridgeWood);
		
		Hotel RidgeWood = new Hotel("RidgeWood", 220, 150);
		log.addHotelBook(RidgeWood);
		
		//Printing Hotel List and Rates
		log.printHotel();
		
		
	}
	
	private static Hotel findcheapesthotel(String start_date, String end_date) {
		//Start and End Dates
		Date startdate = null;
		Date enddate = null;
		
		try {
		 startdate = new SimpleDateFormat("ddMMMyyyy").parse(start_date);
		 enddate = new SimpleDateFormat("ddMMMyyyy").parse(end_date);
		
		}
		
		catch(ParseException e){
			
			e.printStackTrace();
		}
		
		Calendar c = Calendar.getInstance();
		
		long time = (enddate.getTime() - startdate.getTime() )/1000/60/60/24 + 1;

		Hotel cheapesthotel = log.hotelbook.stream().sorted(Comparator.comparing(Hotel :: getWeekday)).findFirst().orElse(null);	
		
		System.out.println(cheapesthotel.getWeekday());
		long total_amount = time*cheapesthotel.getWeekday();
		
		cheapesthotel.setTotalPrice(total_amount);
		return cheapesthotel;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		//UC_0: Welcome Message
		
		System.out.println("Welcome to Hotel Reservation System!!");
		
		//UC_1: Adding Hotel to the Log Book and Printing Hotel Name with Rates for Weekend and Weekdays
		addHotelRegularPrice();
		
		HotelLog log = new HotelLog();
		
		//UC_2: Finding the cheapest Hotel in the given date
		System.out.println("Enter the Check in Date in ddMMMYYYY Format: ");
		String start_date = scan.next();
		
		System.out.println("Enter the Check Out Date in ddMMMYYYY Format: ");
		String end_date = scan.next();
		
		Hotel cheap = findcheapesthotel(start_date, end_date);
		System.out.println(cheap.getHotelName()+" is the Cheapest Hotel with Price $ "+cheap.getTotalPrice());
		
	}
}

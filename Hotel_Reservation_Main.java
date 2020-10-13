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
	
	private static void findcheapesthotel_weekdays() {
		
		//Start and End Dates
		System.out.println("Enter the Check in Date in ddMMMYYYY Format: ");
		String start_date = scan.next();
		
		System.out.println("Enter the Check Out Date in ddMMMYYYY Format: ");
		String end_date = scan.next();
		
		
		Date startdate = null;
		Date enddate = null;
		
		try {
		 startdate = new SimpleDateFormat("ddMMMyyyy").parse(start_date);
		 enddate = new SimpleDateFormat("ddMMMyyyy").parse(end_date);
		
		}
		
		catch(ParseException e){
			
			e.printStackTrace();
		}
		
		Calendar checkin = Calendar.getInstance();
		checkin.setTime(startdate);
		
		Calendar checkout = Calendar.getInstance();
		checkout.setTime(enddate);
		
		
		
		int weekdays = 0;
		
		do {
			if(checkin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && checkin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
				weekdays++;
			checkin.add(Calendar.DAY_OF_MONTH,1);
		}
		while(checkin.getTimeInMillis() <= checkout.getTimeInMillis());
		
		
		
		long time = (enddate.getTime() - startdate.getTime() )/1000/60/60/24 + 1;


		for(Hotel hotel : log.hotelbook) {
			long total_price  = weekdays*hotel.getWeekday();
			hotel.setTotalPrice_weekdays(total_price);
		}
		
		Hotel cheapesthotel = log.hotelbook.stream().sorted(Comparator.comparing(Hotel :: getTotalPrice_weekdays)).findFirst().orElse(null);	
		System.out.println(cheapesthotel.getHotelName()+" is the Cheapest Hotel with Price $ "+cheapesthotel.getTotalPrice_weekdays()+" on Weekdays");
		
		
		for(Hotel hotel : log.hotelbook) {
			long total_price  = (time - weekdays)*hotel.getWeekend();
			hotel.setTotalPrice_weekdays(total_price);
		}
		
		Hotel cheapesthotel_weekend = log.hotelbook.stream().sorted(Comparator.comparing(Hotel :: getTotalPrice_weekend)).findFirst().orElse(null);	
		System.out.println(cheapesthotel_weekend.getHotelName()+" is the Cheapest Hotel with Price $ "+cheapesthotel_weekend.getTotalPrice_weekdays()+" on Weekends");
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		//UC_0: Welcome Message
		
		System.out.println("Welcome to Hotel Reservation System!!");
		
		//UC_1: Adding Hotel to the Log Book and Printing Hotel Name with Rates for Weekend and Weekdays
		addHotelRegularPrice();
		
		HotelLog log = new HotelLog();
		
		//UC_2: Finding the cheapest Hotel in the given date

	 findcheapesthotel_weekdays();
	
	}
}

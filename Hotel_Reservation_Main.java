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
		
		Hotel LakeWood = new Hotel("LakeWood", 110, 90,3,80,80);
		log.addHotelBook(LakeWood);
		
		Hotel BridgeWood = new Hotel("BridgeWood", 160, 60,4,110,50);
		log.addHotelBook(BridgeWood);
		
		Hotel RidgeWood = new Hotel("RidgeWood", 220, 150,5,100,40);
		log.addHotelBook(RidgeWood);
		
		//Printing Hotel List and Rates
		log.printHotel();
		
		
	}
	
	private static void findcheapesthotel() {
		
		//Check for Premium Customer
		System.out.println("Are you a Premium Customer?\nPress 1 for No\nPress 2 for Yes\nPress 3 to Exit");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
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
			long total_price  = (time - weekdays)*hotel.getWeekend() + weekdays*hotel.getWeekday();
			hotel.setTotalPrice_weekdays(total_price);
		}
		
		long price = log.hotelbook.get(2).getTotalPrice();  
		int rating =3;
		
		String name = null ;
		for(Hotel hotel : log.hotelbook) {
			if( hotel.getHotelRating() >= rating ) {
				price = hotel.getTotalPrice();
				rating = hotel.getHotelRating();
				name = hotel.getHotelName();
			}
		}
		
		System.out.println(name+" is the Cheapest Hotel with best Rating and with Price $ "+price+" and Rating "+rating);
		break;
		case 2:
			//Start and End Dates
			System.out.println("Enter the Check in Date in ddMMMYYYY Format: ");
			String start_date_special = scan.next();
			
			System.out.println("Enter the Check Out Date in ddMMMYYYY Format: ");
			String end_date_special = scan.next();
			
			
			Date startdate_special = null;
			Date enddate_special = null;
			
			try {
			 startdate_special = new SimpleDateFormat("ddMMMyyyy").parse(start_date_special);
			 enddate_special = new SimpleDateFormat("ddMMMyyyy").parse(end_date_special);
			
			}
			
			catch(ParseException e){
				
				e.printStackTrace();
			}
			
			Calendar checkin_special = Calendar.getInstance();
			checkin_special.setTime(startdate_special);
			
			Calendar checkout_special = Calendar.getInstance();
			checkout_special.setTime(enddate_special);
			
			
			
			int weekdays_special = 0;
			
			do {
				if(checkin_special.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && checkin_special.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
					weekdays_special++;
				checkin_special.add(Calendar.DAY_OF_MONTH,1);
			}
			while(checkin_special.getTimeInMillis() <= checkout_special.getTimeInMillis());
			
			
			
			long time_special = (enddate_special.getTime() - startdate_special.getTime() )/1000/60/60/24 + 1;
			
			for(Hotel hotel : log.hotelbook) {
				long total_price  = (time_special - weekdays_special)*hotel.getSpecialWeekend() + weekdays_special*hotel.getSpecialWeekday();
				hotel.setTotalPrice_weekdays(total_price);
			}
			
			long price_special = log.hotelbook.get(2).getTotalPrice();  
			int rating_special =3;
			
			String name_special = null ;
			for(Hotel hotel : log.hotelbook) {
<<<<<<< HEAD
				if( hotel.getHotelRating() >= rating_special ) {
=======
				if( hotel.getHotelRating() >= rating_special && hotel.getTotalPrice() <= price_special) {
>>>>>>> UC_11_Loyal_Customer
					price_special = hotel.getTotalPrice();
					rating_special = hotel.getHotelRating();
					name_special = hotel.getHotelName();
				}
			}
			
<<<<<<< HEAD
			System.out.println(name_special+" is the Cheapest Hotel with best Rating and with Price $ "+price_special+" and Rating "+rating_special);
=======
			System.out.println(name_special+" is the Cheapest Hotel with best Rating and with Price $ "+price_special+" for Loyal Customer and Rating "+rating_special);
>>>>>>> UC_11_Loyal_Customer
			break;
			default:
				System.out.println("Invalid Option");
				System.exit(0);
				break;
		}	
	}
	
	
	public static void main(String[] args) throws Exception {
		
		//UC_0: Welcome Message
		
		System.out.println("Welcome to Hotel Reservation System!!");
		
		//UC_1: Adding Hotel to the Log Book and Printing Hotel Name with Rates for Weekend and Weekdays
		addHotelRegularPrice();
		
		HotelLog log = new HotelLog();
		
		//UC_2: Finding the cheapest Hotel in the given date

	 findcheapesthotel();
	
	}
}

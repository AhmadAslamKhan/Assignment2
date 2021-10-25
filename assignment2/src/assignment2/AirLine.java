package assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AirLine {

	public static void main (String[] args) throws FileNotFoundException, IOException, Exceptions {
		
		passenger p1=new passenger();
		Flight f1=new Flight();

		System.out.println("Welcome to our AirLine seat reservation system");
		Scanner scanint = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nPlease Select your desired task");
			System.out.println("1.Book Seat");
			System.out.println("2.View Seat");
			System.out.println("3.Cancle Seat");
			System.out.println("4.Exit");
			System.out.print("Option: ");
			int choice = scanint.nextInt();
			System.out.print("\n");

			if (choice==0 || choice>4){
				throw new Exceptions("Invalid option");
			}
			if (choice==1)
			{
				p1.storeData();
				
				String orig= p1.getCurr_city(); 
				String desti= p1.getDes_city(); 
				
				f1.readflight(orig, desti);
				
				System.out.println();

				f1.getAvailSeats();
				System.out.print("\nPlease select a Seat Number: ");
				int seat = scanint.nextInt();
				p1.setSeat_no(seat);
				f1.setSeat(seat);

				System.out.print("\nPersonal Details: ");
				p1.printData();
				p1.writepassengerfile();
				
				System.out.print("\nFlight Details: ");
				f1.printData();
			}
			else if (choice==2)
			{
				System.out.print("\nPersonal Details: ");
				p1.printData();

				System.out.print("\nFlight Details: ");
				f1.printData();
			}
			else if (choice==3)
			{
				int seat = p1.getSeat_no();
				f1.CanclSeat(seat);
				p1.Cancleseat();
				f1.CancleFlight();
			}
			else if (choice==4)
			{
				System.out.println("Thank You for using our Airline Reservation System");
				break;
			}
		
		}
		
	}
}

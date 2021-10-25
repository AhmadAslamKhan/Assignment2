package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Flight {
	
	private String flight_no;
	private String origion;
	private String dest;
	private String date;
	private String time;
	private String fare;
	private String type;
	private int[] seats = new int[50];
	
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public String getOrigion() {
		return origion;
	}
	public void setOrigion(String origion) {
		this.origion = origion;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void getAvailSeats() {
		System.out.println("\nAvailable Seats are: ");
		
		for (int i=0;i<50;i++) {
			if(seats[i]==0) {
				System.out.println("Seat Number: " + i);
			}
		}
	}
	public void getfilledSeats() {
		System.out.println("\nSeats already taken are: ");
		
		for (int i=0;i<50;i++) {
			if(seats[i]==1) {
				System.out.println("Seat Number: " + i);
			}
		}
	}
	public void setSeat(int num) throws Exceptions {
		if (num<0 || num>49){
			throw new Exceptions("This Seat Number is Not available in the Airplane");
		}
		this.seats[num] = 1;
	}
	public void CanclSeat(int num) throws Exceptions {
		if (num<0 || num>49){
			throw new Exceptions("This Seat Number is Not available in the Airplane");
		}
		this.seats[num] = 0;
	}

	public void printData() {

		System.out.println("\nflight Number: " + flight_no);
		System.out.println("Origion: " + origion);
		System.out.println("Destination: " + dest);
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println("Fare: " + fare);
		System.out.println("Plane type: " + type);
	}

	public void CancleFlight() {

		flight_no=null;
		origion=null;
		dest=null;
		date=null;
		time=null;
		fare=null;
		type=null;
	}
	public void readflight(String orig, String destin) throws FileNotFoundException, IOException {
		String[] word=new String[7];
		int count = 0;
		try {
			File obj = new File("flights.txt");
			Scanner scanfile = new Scanner(obj);
				
			while (scanfile.hasNextLine()) {
				String line = scanfile.nextLine();
				String[] tokens = line.split("\\,");
				
				count=0;
				for (String w : tokens) {
					  word[count]=w;
					  count++;
					}

				
				if (word[1].equals(orig) && word[2].equals(destin)) {

					flight_no=word[0];
					origion=word[1];
					dest=word[2];
					date=word[3];
					time=word[4];
					fare=word[5];
					type=word[6];
				}
			}
			scanfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}




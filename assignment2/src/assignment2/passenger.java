package assignment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class passenger {
	
	private String name;
	private int age;
	private String gender;
	private String address;
	private int pass_no;
	private String curr_city;
	private String des_city;
	private int seat_no;
	
	public passenger() {
		name = null;
		age = 0;
		gender = null;
		address = null;
		pass_no = 0;
		curr_city = null;
		des_city = null;
		seat_no = 0;
	}
	public passenger(String nam,String gend,int ag,String add,int pass, String origin, String dest) {
		name = nam;
		gender = gend;
		age = ag;
		address = add;
		pass_no = pass;
		curr_city = origin;
		des_city = dest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPass_no() {
		return pass_no;
	}
	public void setPass_no(int pass_no) {
		this.pass_no = pass_no;
	}
	
	public String getCurr_city() {
		return curr_city;
	}
	public void setCurr_city(String curr_city) {
		this.curr_city = curr_city;
	}
	
	public String getDes_city() {
		return des_city;
	}
	public void setDes_city(String des_city) {
		this.des_city = des_city;
	}

	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public void printData() {

		System.out.println("\nName: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("address: " + address);
		System.out.println("Passport Number: " + pass_no);
		System.out.println("Origin City: " + curr_city);
		System.out.println("Destination: " + des_city);
		System.out.println("Seat Number: " + seat_no + "\n");
	}
	public void storeData() throws Exceptions {
		
		System.out.println("Please enter your Data:");
		Scanner scanstr = new Scanner(System.in);
		Scanner scanint = new Scanner(System.in);
		
		System.out.print("Name: ");
		name = scanstr.nextLine();
		
		System.out.print("Age: ");
		age = scanint.nextInt();
		if (age<0){
			throw new Exceptions("Age cant be less than 0");
		}
		
		System.out.print("Gender: ");
		gender = scanstr.nextLine();
		if (!gender.equals("Male") || !gender.equals("male") || !gender.equals("Female") || !gender.equals("female")){
			throw new Exceptions("Gender Declaration is False");
		}
		
		System.out.print("address: ");
		address = scanstr.nextLine();
		
		System.out.print("Passport Number: ");
		pass_no = scanint.nextInt();
		if (pass_no<100000000 || pass_no>1000000000){
			throw new Exceptions("Passport Number has to be of 9 digits");
		}
		
		System.out.print("Origin City: ");
		curr_city = scanstr.nextLine();
		if (!curr_city.equals("Islamabad") && !curr_city.equals("Lahore") && !curr_city.equals("Karachi") && !curr_city.equals("Peshawar") && !curr_city.equals("Quetta")){
			throw new Exceptions("No flights are available for this city");
		}
		
		System.out.print("Destination: ");
		des_city = scanstr.nextLine();
		if (!curr_city.equals("Islamabad") && !curr_city.equals("Lahore") && !curr_city.equals("Karachi") && !curr_city.equals("Peshawar") && !curr_city.equals("Quetta")){
			throw new Exceptions("No flights are available for this city");
		}
	}
	public void Cancleseat() {
		
		name = null;
		age = 0;
		gender = null;
		address = null;
		pass_no = 0;
		curr_city = null;
		des_city = null;
		seat_no = 0;
	}
	public void writepassengerfile() {
		try {
			String filewrite = name + ", " + age + ", " + gender + ", " + address + ", " + pass_no + ", " + curr_city + ", " + des_city + ", " + seat_no;

			Files.write(Paths.get("passenger.txt"), "\r\n".getBytes(),
					StandardOpenOption.APPEND);
			Files.write(Paths.get("passenger.txt"),
					(filewrite).getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
	public void readpassengerfile() throws FileNotFoundException, IOException {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("passenger.txt"),StandardCharsets.UTF_8))){
		    String line;
		  	while((line=br.readLine())!=null){
		    	String split=line;
		      	//use the data here
		    		System.out.println(split);
		    }
		}
	}
	

}

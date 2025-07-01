package CAR_SHOWROOM;

import java.util.Scanner;

public class cars extends showrooms implements utility{
	String carName;
	String carColour;
	String carBrand;




	public void set_details() {
	Scanner s=new Scanner(System.in);
		//add Car
		numCars++;
		
		
		
		System.out.print("Car Name:");
		String Name=s.next();
		this.carName=Name;
		
		System.out.print("Car Colour:");
		String colour=s.next();
		this.carColour=colour;
		
		System.out.print("Car Brand:");
		String brand=s.next();
		this.carBrand=brand;
		
		
		
	}



	public void  get_details() {
	    System.out.println("Cars Name: "+carName);
		
		System.out.println("Car Colour: "+carColour);

		System.out.println("Car Brand: "+carBrand);
		}




}

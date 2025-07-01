package CAR_SHOWROOM;
import java.util.Scanner;
public class showrooms implements utility {
String srName;
String srAddress;
String mName;
static int numEmployees;
static int numCars;

public void set_details() {
	Scanner s=new Scanner(System.in);
	System.out.print("Showroom Name:");
	String srName=s.next();
	this.srName=srName;
	s.nextLine();
	
	System.out.print("Showroom Address:");
	String address=s.next();
	this.srAddress=address;
	s.nextLine();
	
	System.out.print("Manager Name:");
	String mName=s.next();
	this.mName=mName;
	s.nextLine();
	
	System.out.print("Total no. of Employees:");
	int employees=s.nextInt();
	this.numEmployees=employees;
	s.nextLine();
	
	System.out.print("Total no. of Cars in Stock:");
	int cars=s.nextInt();
	this.numCars=cars;
	s.nextLine();
}



public void get_details() {
	System.out.println("Showroom Name: "+srName);
	
	System.out.println("Showroom Address: "+srAddress);

	System.out.println("Manager Name: "+mName);
	
	System.out.println("Total no. of Employees: "+numEmployees);

    System.out.println("Total no. of Cars in Stock: "+numCars);
	
	
}




}

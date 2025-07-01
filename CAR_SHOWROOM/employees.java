package CAR_SHOWROOM;

import java.util.Scanner;

public class employees extends showrooms implements utility{
	String empName;
	String empAddress;
	
	

	
	public void set_details() {
		Scanner s=new Scanner(System.in);
		//add Employee
		numEmployees++;
		
		System.out.print("Employee Name:");
		String Name=s.next();
		this.empName=Name;
		
		System.out.print("Employee Address:");
		String address=s.next();
		this.empAddress=address;
		
    }



	public void  get_details() {
		System.out.println("Employee Name: "+empName);
		
		System.out.println("Employee Address: "+empAddress);

		System.out.println("Manager Name: "+mName);
		
		

	   
		
		
	}




	
	
	
	
}

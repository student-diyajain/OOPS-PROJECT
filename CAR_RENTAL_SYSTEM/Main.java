package CAR_RENTAL_SYSTEM;

import java.util.ArrayList;
import java.util.Scanner;

import EMPLOYEE_PAYROLL_SYSTEM.Employee;
//Car class--
class Car{
	private String carId;
	private String carBrand;
	private String carModel;
	private double basePricePerDay;
	private boolean isAvailable;
	
	//create constructor which adds car and set true to car availability
	public Car(String carId, String carBrand, String carModel, int basePricePerDay) {
		super();
		this.carId = carId;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable =true;
	}
	
	
	public String getCarId() {
		return carId;
	}
	
	public String getCarBrand() {
		return carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	 public double calculatePrice(int rentalDays) {
		 return  basePricePerDay*rentalDays;
		 
	 }
	 
	 public void rentCar() {  //car ab nhi hai
		 isAvailable=false;
	 }
	 public void returnCar() { //car firse aagyi
		 isAvailable=true;
	 }
}

//Customer class--
class Customer{
	private String customerId;
	private String customerName;
	public String getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public Customer(String customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}
}

//Rental class--(it stores combination of car and customer)
//Jaise hi koi car rent krogen uski info isme dalegi customer or rentalDays k sath
class Rental{         
	private int rentalDays; //kitne dino tk rent krni hai
	private Car car;
	private Customer customer;
	
	public Car getCar() {
		return car;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public int getRentalDays() {
		return rentalDays;
	}
	//kitne dino tk konsi car konsa customer lejayega
	public Rental( Car car, Customer customer,int rentalDays) { 
		this.rentalDays = rentalDays;
		this.car = car;
		this.customer = customer;
	}
	
}



//most important class---
//CarRentalSystem---
class CarRentalSystem{
	ArrayList<Car> carList;  //car ki list
	ArrayList<Customer> customerList; //customer ki list
	ArrayList<Rental> rentalList; //car+customer ki list
	
	public CarRentalSystem() {      //it creates all three list
		this.carList = new ArrayList<>();
		this.customerList = new ArrayList<>();
		this.rentalList = new ArrayList<>();
	}
	
	//addCar
	public void addCar(Car car) {
			carList.add(car);
	}
		
   //addCustomer
	public void addCustomer(Customer customer) {
			customerList.add(customer);
	}
		
		
    /*car ko rent krenge and  rental m add krenge
    uske liye hme tin chize dene hogi  
    1.konsi car
    2.konsa customer
    3.kitne dino tk
    */
	//rentCar--       
	public void rentCar(Car car,Customer customer,int rentalDays) {
		//check car is available or not 
		if(car.isAvailable()) {
			car.rentCar();   //rent kr diya 
			rentalList.add(new Rental(car,customer,rentalDays)); //uski information rental m store krdi
			System.out.println("car rent successfully.");
			System.out.println();
		}
		else {
			System.out.println("car is not available for rent!!");
			System.out.println();
		}
	
		
	}
	
	//car ko return krenge and rental s remove krenge
	//returnCar--     
	public void returnCar(Car car) {
		
		Rental RentalToRemove=null;
		for(Rental rental:rentalList) {
			if(rental.getCar()==car) {
				RentalToRemove=rental;
				break;
			}
		}
		if(RentalToRemove!=null) {
			rentalList.remove(RentalToRemove);
			car.returnCar();
			System.out.println("car returned successfully.");
			
		}
		else {
			System.out.println("Car was not returned");
			System.out.println();
		}
		
	}
		
		//create a menu-----
		public void menu() {
			System.out.println("==========Welcome To Car Rental System==========");
		while(true) {
			Scanner s=new Scanner(System.in);
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. Exit ");
			System.out.print("Enter your choice:");
			int choice=s.nextInt();
            if(choice==1) {
            	
            	System.out.print("\n== Rent a Car ==");
            	System.out.println();
            	System.out.print("\nEnter Your name:");
            	String name =s.next(); //1.
            	System.out.print("\nAvailable Cars:");
            	System.out.println();
            	//already available cars
            	if(carList.size()==0) {
        			System.out.print("No Cars Available!!");
        		}else {
            	for(Car car:carList ){
            		
            		 if(car.isAvailable()) {
            		System.out.println(car.getCarId()+" - "+car.getCarBrand()+" "+car.getCarModel());
            		}
            	}
        		}
                System.out.println();
            	System.out.print("Enter the car ID you want to rent:");  //2.
            	String carId =s.next();
            	s.nextLine();
            	
            	System.out.print("Enter the number of days for rental:");  //3.
            	int rentalDays =s.nextInt();
            	System.out.println();
            	
            	//create customer 
            	Customer Newcustomer =new Customer ("CUS"+(customerList.size()+1),name);
            	
            	//find a car--
            	Car selectedCar=null;
                //with the help of id i get the car--
        		for(Car car:carList) {
                if(car.getCarId().equals(carId) && car.isAvailable()) {
        				selectedCar=car;
        				break;
        			}
        		}
        	
        		if(selectedCar!=null) {  //car mil chuki hai
        			//before renting a car
        			System.out.println("== Rental a Information ==");
                	System.out.println("Customer ID: "+Newcustomer.getCustomerId());
                	System.out.println("Customer Name:"+Newcustomer.getCustomerName());
                	System.out.println("Car:"+selectedCar.getCarBrand()+" "+selectedCar.getCarModel());
                	System.out.println("Rental Days:"+rentalDays);
                	System.out.printf("Total Prize: $%.2f%n",selectedCar.calculatePrice(rentalDays));
                	System.out.println();
                	System.out.print("Confirm rental (Y/N):");
                	String decision=s.next();
                	if(decision.equalsIgnoreCase("Y")) {  //upper case or lower case ko ignore krta hai
        			rentCar(selectedCar,Newcustomer,rentalDays) ;
                	}else {
                		System.out.println("Rental cancelled!!");
                	}
        		}else {
        			System.out.println("Invalid Car Selection or Car is not Available!!");
        			System.out.println();
        		}
     
             } else if(choice==2) {
            	 
            	 
            	 
            	 
            	 
            	
                System.out.print("\n== Return a Car ==");
                System.out.println();
             	System.out.print("Enter the car ID you want to return:");  //2.
             	String carId =s.next();
             	s.nextLine();
             	
             
                //find a car--
             	Car carToReturn=null;
         	    //with the help of id i search the car--
         		for(Car car:carList) {
                 if(car.getCarId().equals(carId) && !car.isAvailable()) {
                	 carToReturn=car;
         				break;
         			}
         		}
         		//car mil chuki hai jo rent pr gyi hui thi
         		
         		
         		if(carToReturn!=null) { 
         			//now we find customer of that car
         	        Customer customer=null;
         		    for(Rental rental:rentalList) {
         			  if(rental.getCar()==carToReturn) {
         				  customer=rental.getCustomer();
         				  break;
         			  }
         	        }
         		    
         		    //customer milne k baad use return back kr denge
         		    if(customer!=null) {
         		    	returnCar(carToReturn);
         		    	System.out.println("car returned successfully by "+customer.getCustomerName());
         		    	
         		    }else {
         		    	System.out.println("car was not rented or rental information is missing.");
         		    }
         		 }else {
         			 System.out.println("Invalid Car ID or Car is not rented!!");
         			 System.out.println();
         		 }
      
             
 	 
            	 
            	 
            	 
            	 
            	 
	
            }else if(choice==3) {
            	break;
	
            }else {
	        System.out.println("Invalid Choice"+" "+"please Enter again!!!");
	        
            }
		}
		//after ending while loop
		System.out.println("Thankyou for using the Car Rental System.");
		
		
		
	  }
		
}






public class Main {

	public static void main(String[] args) {
		
	Car c1=new Car("101","Toyota","Camry",1500);
	Car c2=new Car("102","Honda","Accord",1000);
CarRentalSystem crs=new CarRentalSystem();
crs.addCar(c1);
crs.addCar(c2);
crs.menu();
	}

}

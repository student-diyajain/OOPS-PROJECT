package CAR_SHOWROOM;
import java.util.Scanner;
public class main {
	 public static void menu() {
		//Menu:
		    System.out.println("Enter Your Choice:");
		    System.out.println("1.Add Showroom");
			System.out.println("2.Get Showroom");
			System.out.println("3.Add Employee");
			System.out.println("4.Get Employee");
			System.out.println("5.Add Car");
			System.out.println("6.Get Car");
			System.out.println("0.Exit");
	}
	 private static void exit() {
			System.out.print("Thankyou");
			try {
			for(int i=0;i<=5;i++) {
				Thread.sleep(555);
				System.out.print(".");
			}
			}
			catch(Exception e) {
				System.out.println("error!");
			}
		
		}
	 
	
    public static void main(String[] args) {
    	
       showrooms [] showrooms=new showrooms[5];
       employees [] employees=new employees[5];
       cars [] cars=new cars[5];
   
   
       //to traverse the array of classes
       int S=0;
       int E=0;
       int C=0;
		
   	   while(true) {
	   menu();
	   Scanner s=new Scanner(System.in);
	   int choice=s.nextInt();
		switch(choice) {
		case 0:
			exit();
			return;
			
		case 1:
			showrooms[S] =new showrooms();
			showrooms[S].set_details();
			S++;
			break;
			
		case 2:
			for(int i=0;i<S;i++) {
			showrooms[i].get_details();
			System.out.println();
			}
			break;
			
		case 3:
			employees[E] =new employees();
		    employees[E].set_details();
		    E++;
		    break;
		    
		case 4:
			for(int i=0;i<E;i++) {
				employees[i].get_details();
				System.out.println();
				}
			 System.out.println("Total no. of Employees: "+showrooms[S].numEmployees);

				break;
			
		case 5:
			cars[C] =new cars();
			cars[C].set_details();
			C++;
			break;
			
		case 6:
			for(int i=0;i<C;i++) {
				cars[i].get_details();
				 System.out.println();
				}
			 System.out.println("Total no. of Cars in Stock: "+showrooms[S].numCars);
			
				break;
			
	    default:
				System.out.println("Invalid choice!!");
				break;
		}
	}		
       }
}



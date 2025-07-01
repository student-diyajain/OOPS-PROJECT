package ATM_MACHINE;
import java.util.Scanner;
public class ATM {
	Scanner s=new Scanner(System.in);
    final int pin=1234;
    double balance;
    
    
    //non-parameterized constructor
    public ATM() {
		checkPin();
	}
    
    
    
    
    public void checkPin() {
    	//ASK-PIN:
    	System.out.println("Enter pin to open ATM:");
    	int pin=s.nextInt();
    	if(this.pin!=pin) {
    		System.out.println("Invalid Pin");
    		checkPin();
    	}
    	else {
    		menu();
    	}
	}
    
  

private void menu() {
	 //MENU:
	    System.out.println("1.Account Balance");
		System.out.println("2.Withdrawn Money");
		System.out.println("3.Deposit Money");
		System.out.println("4.Exit");
		while(true) {
	    System.out.println("Enter your choice!!");
		int choice=s.nextInt();
		switch(choice) {
		case 1:checkBalance();
		       break;
		case 2:withdrawnMoney(s);
		       break;
		case 3:depositMoney(s);
		       break;
		case 4:exit();
		       return;
	    default:
				System.out.println("Invalid choice!!");
				break;
		}
		}
    }












	private void checkBalance() {
		System.out.println("Total Balance: "+balance);
		
	}
	private void withdrawnMoney(Scanner s) {
		System.out.println("Enter Money you want to withdrawn-");
		double amt=s.nextDouble();
		if(amt>balance) {
			System.out.println("no amount for withdrawn");
			return;
		}
		
		this.balance=balance-amt;
		System.out.println(amt+" Money WithDrawn!!");
		
	}
	private void depositMoney(Scanner s) {
		System.out.println("Enter Money you want to Deposit-");
		double amt=s.nextDouble();
		this.balance=balance+amt;
		System.out.println(amt+" Money Deposit!!");
		
	}
	private void exit() {
		System.out.println("Thankyou........");
		return;
	}
	
    
    
	

}

package EMPLOYEE_PAYROLL_SYSTEM;

public class Main {

	public static void main(String[] args) {
	PartTimeEmployee employee1=new PartTimeEmployee("diya",101,3,1500);
	FullTimeEmployee employee2=new FullTimeEmployee("charu",102,1200000);
	PayrollSystem PS=new PayrollSystem();
	PS.addEmployee(employee1);
	PS.addEmployee(employee2);
	PS.displayEmployee();
	PS.removeEmployee(102);
	
	PS.displayEmployee();
	PS.removeEmployee(105);
	}

	
}

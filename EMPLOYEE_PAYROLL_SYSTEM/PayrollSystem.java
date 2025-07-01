package EMPLOYEE_PAYROLL_SYSTEM;

import java.util.ArrayList;

public class PayrollSystem {
	ArrayList<Employee> employeeList;

	public PayrollSystem() {
		employeeList=new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee removeEmployee=null;
		
		//with the help of id i get the employee--
		for(Employee e:employeeList) {
			if(e.getId()==id) {
				removeEmployee=e;
				break;
			}
		}
	
		if(removeEmployee!=null) {
			employeeList.remove(removeEmployee);
		}else {
			System.out.println("Employee is already removed!!");
		}
	}
	
	public void displayEmployee() {
		for(Employee e:employeeList) {
			System.out.println(e);
		}
	}
	
	
	

}

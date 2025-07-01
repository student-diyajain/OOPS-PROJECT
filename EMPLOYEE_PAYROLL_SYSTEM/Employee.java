package EMPLOYEE_PAYROLL_SYSTEM;

public abstract class Employee {
private String name;
private int id;

public Employee(String name, int id) {
	this.name = name;
	this.id = id;
}

public String getName() {
	return name;
}

public int getId() {
	return id;
}

//abstract method--
public abstract double calculateSalary();

//toString Function--
@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + ", Salary=" + calculateSalary() + "]";
}

}

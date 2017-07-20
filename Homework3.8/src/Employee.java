public class Employee {
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void raiseSalary(double percent) {
		salary *= 1.0 + percent / 100.0;
	}
	
	public double getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
}

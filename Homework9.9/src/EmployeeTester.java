public class EmployeeTester {
	public static void main(String[] args) {
		Employee bill = new Employee("Bill", 50000);
		Manager frank = new Manager("Frank", 70000, "Managing"); // manager of managing
		Executive john = new Executive("John", 10000000, "Managing"); // executive of managing: a very prestigious and well paid position.
		System.out.println(bill);
		System.out.println(frank);
		System.out.println(john);
	}
}

public class PersonTester {
	public static void main(String[] args) {
		Person john = new Person("John", 3128);
		System.out.println(john.getName() + ", " + john.getBirthYear());
		
		Student billy = new Student("Billy", 3128, "Nuclear Bio-Aerophysics (psychology emphasis)");
		System.out.println(billy.getName() + ", " + billy.getBirthYear() + ", " + billy.getMajor());
		
		Instructor tom = new Instructor("Billy", 3128, 2); // $2 per year (currency in 3128 is worth a lot)
		System.out.println(tom.getName() + ", " + tom.getBirthYear() + ", $" + tom.getSalary() + "/y");

		System.out.println(john);
		
		System.out.println(tom instanceof Person);
		System.out.println(billy instanceof Person);
		System.out.println(billy instanceof Person);
		System.out.println(john instanceof Student);
		System.out.println(john instanceof Instructor);
	}
}

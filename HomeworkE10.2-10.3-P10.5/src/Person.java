import java.util.Random;

public class Person implements Measurable {
	private String name;
	private double height;
	
	public Person(String name, double height) {
		this.name = name;
		this.height = height;
	}
	
	public double getMeasure() {
		return height;
	}
	
	public String getName() {
		return name;
	}
	
	public static Person randomPerson(Random random) {
		// names from https://www.ssa.gov/OACT/babynames/
		final String[] names = { "Noah", "Emma", "Liam", "Olivia", "William", "Ava", "Mason", "Sophia", "James", "Isabella", "Benjamin", "Mia", "Jacob", "Charlotte" };

		// bell curve centered around .5
		// based on http://jsfiddle.net/Guffa/tvt5K/
		double h = (random.nextDouble() + random.nextDouble() + random.nextDouble() + random.nextDouble() + random.nextDouble() + random.nextDouble() - 3) / 3;
		
		h = h*30 + 170; // (-1, 1) to (140, 200)
		
		return new Person(names[random.nextInt(names.length)], h);
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		Person[] people = new Person[100];
		for (int i = 0; i < people.length; i++)
			people[i] = randomPerson(rand);
		

		double avg = Data.average(people);
		Measurable max = Data.max(people);
		System.out.println("Avg:\t" + String.format("%.2f", avg));
		System.out.println("Max:\t" + String.format("%.2f", max.getMeasure()));
	}
}

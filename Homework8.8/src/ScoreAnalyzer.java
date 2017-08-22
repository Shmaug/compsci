import java.util.ArrayList;
import java.util.Scanner;

public class ScoreAnalyzer {
	public static void main(String[] args) {
		
		ArrayList<Student> students = new ArrayList<Student>();

		
		Gradebook gradebook = new Gradebook();
		
		String name = "", num = "";
		Student student;
		Scanner in = new Scanner(System.in);
		double score = -1;
		
		System.out.print("Enter student name, or 'quit' to quit: ");
		while (in.hasNextLine()) {
			// for some reason Java does not let you clear a scanner's input.
			// So instead I just make a new one.
			
			name = in.nextLine();
			
			if (name.equalsIgnoreCase("quit")) break;
			
			student = new Student(name, 100);
			gradebook.addStudent(student);
			
			System.out.println("Please enter scores, or 'q' to quit");
			while (true) {
				
				// get a double from the user.
				while (in.hasNextLine()) {
					num = in.nextLine();
					if (num.equals("q")) break;
					score = -1;
					try {
						score = Double.parseDouble(num); // why isn't there a tryParseDouble function?
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid score.");
					}
				}
				if (num.equals("q")) break;
				
				if (!student.addScore(score)) {
					System.out.println("Too many scores.");
					break;
				}
			}
			
			System.out.println(student.toString());
			
			System.out.print("Enter student name, or 'quit' to quit: ");
		}
		
		System.out.println(gradebook);
		
		in.close();
	}
}

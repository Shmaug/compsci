import java.util.ArrayList;

public class Gradebook {
	private ArrayList<Student> students;
	
	public Gradebook() {
		students = new ArrayList<Student>();
	}
	
	public int addStudent(Student student) {
		students.add(student);
		return students.size() - 1;
	}
	
	public String toString() {
		String str = "";
		for (Student s : students)
			str += s.getName() + ": " + s.finalScore() + "\n";
		return str;
	}
}

public class Student {
	private double[] scores;
	private String name;
	
	public Student(String name, int capacity) {
		this.name = name;
		scores = new double[capacity];
		for (int i = 0; i < scores.length; i++)
			scores[i] = -1;
	}
	
	public String getName() {
		return name;
	}
	public boolean addScore(double score) {
		for (int i = 0; i < scores.length; i++)
			if (scores[i] == -1) {
				scores[i] = score;
				return true;
			}
		return false;
	}
	public double finalScore() {
		double lowest = scores[0];
		double sum = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] != -1) {
				if (scores[i] < lowest) lowest = scores[i];
				sum += scores[i];
			}
		}
		return sum - lowest;
	}
	
	public String toString() {
		String str = name + ": ";
		for (int i = 0; i < scores.length; i++)
			if (scores[i] != -1) 
				str += scores[i] + ", ";
		return str;
	}
}

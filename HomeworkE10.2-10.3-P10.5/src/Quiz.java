import java.util.Random;

public class Quiz implements Measurable {
	private double score;
	private String grade;
	
	public Quiz(double score) {
		this.score = score;
		grade = scoreToGrade(score);
	}
	
	public double getMeasure() {
		return score;
	}
	public String getGrade() {
		return grade;
	}
	
	static String scoreToGrade(double score) {
		if (score < .6)
			return "F";
		else if (score < .62)
			return "D-";
		else if (score < .67)
			return "D";
		else if (score < .7)
			return "D+";
		else if (score < .73)
			return "C-";
		else if (score < .77)
			return "C";
		else if (score < .8)
			return "C+";
		else if (score < .83)
			return "B";
		else if (score < .87)
			return "B";
		else if (score < .9)
			return "B+";
		else if (score < .93)
			return "A-";
		else if (score < 1)
			return "A";
		else
			return "A+";
	}
	
	
	// tester
	public static void main(String[] args) {
		Quiz[] quizzes = new Quiz[40];
		
		Random random = new Random();
		double x;
		for (int i = 0; i < quizzes.length; i++) {
			// bell curve centered around .5
			// based on http://jsfiddle.net/Guffa/tvt5K/
			x = (random.nextDouble() + random.nextDouble() + random.nextDouble() + random.nextDouble() + random.nextDouble() + random.nextDouble() - 3) / 3;
			x = x*.5 + .5; // (-1,-1) to (0,1)
			quizzes[i] = new Quiz(x);
			System.out.println(String.format("%.2f", quizzes[i].score));
		}
		
		double avg = Data.average(quizzes);
		Measurable max = Data.max(quizzes);
		System.out.println("Avg:\t" + String.format("%.2f", avg) + "(" + scoreToGrade(avg) + ")");
		System.out.println("Max:\t" + String.format("%.2f", max.getMeasure()) + "(" + scoreToGrade(max.getMeasure()) + ")");
	}
}

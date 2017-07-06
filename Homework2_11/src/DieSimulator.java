import java.util.Random;

public class DieSimulator {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int roll = rand.nextInt(6) + 1;
		System.out.println(roll);
	}
}

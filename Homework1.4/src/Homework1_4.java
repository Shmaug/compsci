public class Homework1_4 {
	public static void main(String[] args){
		double balance = 1000;
		double interest = .05;
		for (int i = 0; i < 3; i++){
			balance *= 1 + interest;
			System.out.println("year " + (i+1) + ": $" + balance);
		}
	}
}

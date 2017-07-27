import java.util.ArrayList;

public class Lab7_8 {
	public static void main(String[] args) {
		int[] result = new int[10];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) nums.add(i);
		
		for (int i = 0; i < 10; i++) {
			result[i] = nums.remove((int)(Math.random() * nums.size()));
			
			System.out.print(result[i] + (i==9 ? "" : ", "));
		}
	}
}

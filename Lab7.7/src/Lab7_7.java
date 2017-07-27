import java.util.Arrays;

public class Lab7_7 {
	public static void main(String[] args) {
		int[] array = { 1, 4, 9, 16, 9, 7, 4, 9, 11, 5 };
		for (int i =0 ; i < array.length/2; i++) {
			int t = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = t;
		}
		System.out.println(Arrays.toString(array));
	}
}

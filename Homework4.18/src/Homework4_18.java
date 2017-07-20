public class Homework4_18 {
	public static void main(String[] args) {
		final String months = "January   Februrary March     April     May       June      July      August    September October   November  December  ";
		final int[] nums = { 1,2,3,4,5,6,7,8,9,10,11,12 };
		
		// Is the hint:
		// 	 	Hint: Make a very long string "January February March ...", in which you add spaces
		//  	such that each month name has the same length. Then use sub string to extract the month you want. 
		// really necessary? I would have just had another array of strings { "January", "Februrary", ... , "December" }
		// and indexed them with the number in question. Or used a Calendar class, built-in to java already
		
		for (int i = 0; i < 12; i++)
			System.out.println(months.substring(i*10, i*10 + 10));
	}
}

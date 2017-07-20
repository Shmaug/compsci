import java.util.Scanner;

public class MagicSquares {
	static boolean magicSquare(int[][] nums){
		int[] sums = new int[10];
		// 0 to 3 are row sums
		// 4 to 7 are column sums
		// 8 and 9 are diagonals
		
		for (int i = 0; i < 4; i++){
			sums[8] += nums[i][i];
			sums[9] += nums[3 - i][i];
			for (int j = 0; j < 4; j++){
				// [i][...]
				sums[i] += nums[i][j];
				// [...][i]
				sums[4 + i] += nums[j][i];
			}
		}

		//for (int i = 0; i < sums.length; i++)
		//	System.out.print(sums[i] + " ");
		//System.out.println("");
			
		for (int i = 1; i < sums.length; i++)
			if (sums[i] != sums[i - 1]) return false;
		
		return true;
	}
	
	public static void main(String[] args){
		String sqr = "16 3 2 13 5 10 11 8 9 6 7 12 4 15 14 1";
		
		System.out.print("Enter 16 numbers separated by spaces: ");
		
		Scanner in = new Scanner(System.in);
		String instr = in.nextLine();
		
		if (instr.equals("sqr")) instr = sqr;
		
		String[] inarr = instr.split(" ");
		in.close();
		if (inarr.length != 16) {
			System.out.println("Input was not 16 numbers separated by spaces");
			return;
		}
		
		int[][] nums = new int[4][4];
		for (int i = 0; i < 16; i++)
			nums[i / 4][i % 4] = Integer.parseInt(inarr[i]);
		
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 4; y++)
				System.out.print(nums[x][y] + " ");
			
			System.out.println();
		}
		
		System.out.println(magicSquare(nums));
	}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ColumnAverager {
		public static void main(String[] args) {
		Scanner sysin = new Scanner(System.in);
		
		System.out.println("Enter input file");
		String inputpath = sysin.nextLine();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(inputpath);
			br = new BufferedReader(fr);
			
			int count1 = 0;
			int count2 = 0;
			double sum1 = 0;
			double sum2 = 0;
			String line;
			while ((line = br.readLine()) != null) {
				String[] nums = line.trim().split("\\s+");
				if (nums.length == 2) {
					sum1 += Double.parseDouble(nums[0]);
					count1++;
					
					sum2 += Double.parseDouble(nums[1]);
					count2++;
				}
			}
			
			double avg1 = count1 > 0 ? sum1/count1 : 0;
			double avg2 = count2 > 0 ? sum2/count2 : 0;
			System.out.println(String.format("Column Averages:\n%.2f\t%.2f", avg1, avg2));
		}catch(IOException e) {
			System.out.println("IO error: " + e);
		}finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

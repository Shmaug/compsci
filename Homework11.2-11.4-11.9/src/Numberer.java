import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Numberer {
	public static void main(String[] args) {
		Scanner sysin = new Scanner(System.in);
		
		System.out.println("Enter input file");
		String inputpath = sysin.nextLine();
		
		System.out.println("Enter output file");
		String outputpath = sysin.nextLine();
		
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			fw = new FileWriter(outputpath);
			bw = new BufferedWriter(fw);
			fr = new FileReader(inputpath);
			br = new BufferedReader(fr);
			
			int c = 0;
			String line;
			while ((line = br.readLine()) != null) {
				c++;
				bw.write("/* " + c + " */ " + line);
				bw.newLine();
			}
			
		}catch(IOException e) {
			System.out.println("IO error: " + e);
		}finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

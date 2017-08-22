import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NameSort {
	public static void main(String[] args) {
		// I couldn't find babynames.txt so i made my own
		
		Scanner sysin = new Scanner(System.in);
		
		System.out.println("Enter input file");
		String inputpath = sysin.nextLine();
		
		System.out.println("Enter output directory");
		String outputpath = sysin.nextLine();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fwboy = null;
		BufferedWriter bwboy = null;
		FileWriter fwgirl = null;
		BufferedWriter bwgirl = null;
		
		try {
			fwboy = new FileWriter(outputpath + "/boynames.txt");
			bwboy = new BufferedWriter(fwboy);
			fwgirl = new FileWriter(outputpath + "/girlnames.txt");
			bwgirl = new BufferedWriter(fwgirl);
			fr = new FileReader(inputpath);
			br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
				String[] names = line.trim().split("\\s+");
				
				bwboy.write(names[0]);
				bwboy.newLine();
				
				bwgirl.write(names[1]);
				bwgirl.newLine();
			}
			
		}catch(IOException e) {
			System.out.println("IO error: " + e);
		}finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
				if (bwboy != null) bwboy.close();
				if (fwboy != null) fwboy.close();
				if (bwgirl != null) bwgirl.close();
				if (fwgirl != null) fwgirl.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

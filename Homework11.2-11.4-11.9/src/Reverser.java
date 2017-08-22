import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reverser {
	public static void main(String[] args) {
		String inputpath = "";
		String outputpath = "";
		
		if (args.length != 2) {
			Scanner sysin = new Scanner(System.in);
			
			System.out.println("Enter input file");
			inputpath = sysin.nextLine();
			
			System.out.println("Enter output file");
			outputpath = sysin.nextLine();
		}else {
			inputpath = args[0];
			outputpath = args[1];
		}
		
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			fw = new FileWriter(outputpath);
			bw = new BufferedWriter(fw);
			fr = new FileReader(inputpath);
			br = new BufferedReader(fr);
			
			ArrayList<String> lines = new ArrayList<String>();
			
			String line;
			while ((line = br.readLine()) != null)
				lines.add(line);
			
			for (int i = lines.size() - 1; i >= 0; i--) {
				bw.write(lines.get(i));
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

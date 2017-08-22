import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private ArrayList<BankAccount> accounts;
	
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}
	
	public boolean readFile(String path) {
		ArrayList<BankAccount> newacc = new ArrayList<BankAccount>();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null){
				BankAccount acc = new BankAccount();
				if (!acc.read(line))
					return false;
				else
					newacc.add(acc);
			}
			
		}catch(IOException e) {
			System.out.println("IO error: " + e);
			return false;
		}finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		accounts.clear();
		accounts.addAll(newacc);
		return true;
	}
	
	public BankAccount getHighest() {
		BankAccount h = null;
		for (BankAccount b : accounts)
			if (h == null || b.getBalance() > h.getBalance())
				h = b;
		
		return h;
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Scanner sysin = new Scanner(System.in);
		
		String inputpath = "";
		File file = null;
		while (file == null || !file.exists() || !bank.readFile(inputpath)) {
			System.out.println("Enter input file");
			inputpath = sysin.nextLine();
			file = new File(inputpath);
		}
		
		BankAccount highest = bank.getHighest();
		System.out.println(highest);
		
		sysin.close();
	}
}

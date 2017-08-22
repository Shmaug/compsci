import java.util.Scanner;

public class LoginForm {
	private String name, password;
	
	private String correctName, correctPassword;
	private boolean loggedIn;
	
	public LoginForm(String name, String password) {
		correctName = name;
		correctPassword = password;
		loggedIn = false;
	}
	
	public void input(String text) {
		if (loggedIn) return;
		
		if (name == null)
			name = text;
		else
			password = text;
	}
	public void click(String button) {
		if (loggedIn) return;
		
		if (button.equals("Submit"))
			if (name.equals(correctName) && password.equals(correctPassword))
				loggedIn = true;
		
		// this isn't necessarry, it resets when you click either button anyways
		//else if (button.equals("Reset")) {
		//	name = password = null;
		//}
		
		name = password = null;
	}
	public boolean loggedIn() {
		return this.loggedIn;
	}
	
	public static void main(String[] args) {
		LoginForm form = new LoginForm("john", "hunter2");
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter name: ");
			form.input(in.nextLine());
			System.out.print("Enter password: ");
			form.input(in.nextLine());
			
			form.click("Submit");
			
			if (form.loggedIn) {
				System.out.println("logged in sucessfully");
				break;
			}else
				System.out.println("Invalid login");
		}
		
		in.close();
	}
}

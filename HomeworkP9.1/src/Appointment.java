import java.util.Scanner;

public abstract class Appointment {
	private String description;
	
	public Appointment(String desc) {
		description = desc;
	}
	
	public String getDescription() {
		return description;
	}
	
	public abstract boolean occursOn(int day, int month, int year);
	
	public static void main(String[] args) {
		// Seriously? when does the book teach enums? this is why Java is so verbose and ugly
		
		Appointment[] appointments = {
				new Daily("eat food"),
				new Monthly("get gas", 5),
				new Onetime("visit friend", 5, 2, 2018),
				new Monthly("go to store", 15),
				new Monthly("go to store", 1)
		};
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter date mm/dd/yyyy: ");
		String input = scanner.nextLine();
		String[] mmddyyyy = input.split("/");
		if (mmddyyyy.length == 3) {
			int month = Integer.parseInt(mmddyyyy[0]);
			int day = Integer.parseInt(mmddyyyy[1]);
			int year = Integer.parseInt(mmddyyyy[2]);
			// this crashes if the user doesnt put ints between the slashes, but the assignment doesn't tell me to handle that.
			for (int i = 0; i < appointments.length; i++)
				if (appointments[i].occursOn(year, month, day))
					System.out.println(appointments[i].getDescription());
		}else {
			System.out.println("invalid");
		}
		
		scanner.close();
	}
}

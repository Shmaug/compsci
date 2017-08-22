public class Monthly extends Appointment {
	public int day;
	
	public Monthly(String desc, int day) {
		super(desc);
		this.day = day;
	}
	
	public boolean occursOn(int year, int month, int day) {
		return this.day == day;
	}
}

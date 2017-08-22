public class Onetime extends Appointment {
	public int day;
	public int month;
	public int year;
	
	public Onetime(String desc, int day, int month, int year) {
		super(desc);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean occursOn(int year, int month, int day) {
		return this.day == day && this.month == month && this.year == year;
	}
}

public class Daily extends Appointment {
	public Daily(String desc) {
		super(desc);
	}
	
	public boolean occursOn(int year, int month, int day) {
		return true;
	}
}

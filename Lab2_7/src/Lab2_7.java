import java.util.GregorianCalendar;

public class Lab2_7 {
	public static void main(String[] args){
		String[] weekdays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(GregorianCalendar.DAY_OF_YEAR, 100);
		System.out.println("Date 100 days from today: " +
				(cal.get(GregorianCalendar.MONTH)+1) + "/" + // add 1 to make days start at 1
				(cal.get(GregorianCalendar.DAY_OF_MONTH)+1) + "/" +
				cal.get(GregorianCalendar.YEAR) );
		System.out.println("Weekday 100 days from today: " + weekdays[cal.get(GregorianCalendar.DAY_OF_WEEK)]);

		GregorianCalendar bday = new GregorianCalendar(1998, 6, 18);
		bday.add(GregorianCalendar.DAY_OF_YEAR, 10000);
		System.out.println("Date 10000 days from birthday: " +
				(bday.get(GregorianCalendar.MONTH)+1) + "/" +
				(bday.get(GregorianCalendar.DAY_OF_MONTH)+1) + "/" +
				bday.get(GregorianCalendar.YEAR) );
	}
}

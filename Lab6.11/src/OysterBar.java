public class OysterBar {
	private int curOccupancy = 0;
	private int maxOccupancy;
	
	public OysterBar(int max) {
		maxOccupancy = max;
	}
	
	public int getOccupants() {
		return curOccupancy;
	}
	
	public boolean HandleGroup(int size) {
		if (curOccupancy + size > maxOccupancy) return false;
		
		curOccupancy += size;
		return true;
	}
	
	public static void main(String[] args) {
		OysterBar b = new OysterBar(100);
		
		System.out.println("Adding 10 people..." + b.HandleGroup(10) + " (" + b.getOccupants() + ")");
		System.out.println("Adding 5 people..." + b.HandleGroup(5) + " (" + b.getOccupants() + ")");
		System.out.println("Adding 3 people..." + b.HandleGroup(3) + " (" + b.getOccupants() + ")");
		System.out.println("Adding 100 people..." + b.HandleGroup(100) + " (" + b.getOccupants() + ")");
		System.out.println("Removing 10 people..." + b.HandleGroup(-10) + " (" + b.getOccupants() + ")");
		System.out.println("Removing 5 people..." + b.HandleGroup(-5) + " (" + b.getOccupants() + ")");
		System.out.println("Removing 3 people..." + b.HandleGroup(-3) + " (" + b.getOccupants() + ")");
		System.out.println("Adding 100 people..." + b.HandleGroup(100) + " (" + b.getOccupants() + ")");
	}
}

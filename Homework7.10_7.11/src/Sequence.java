
public class Sequence {
	private int[] values;
	public Sequence(int size) {
		values = new int[size];
	}
	
	public void set(int i, int n) {
		values[i] = n;
	}
	
	public boolean equals(Sequence other){
		if (other.values.length != values.length) return false;
		
		for (int i = 0; i < other.values.length; i++)
			if (other.values[i] != values[i]) return false;
		
		return true;
	}
	
	public boolean sameValues(Sequence other){
		boolean found = false; // Don't spam the garbage collector :)
		
		for (int i = 0; i < values.length; i++){
			found = false;
			
			for (int j = 0; j < other.values.length; j++)
				if (values[i] == other.values[j]) {
					found = true;
					break;
				}
			
			if (!found) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Sequence a = new Sequence(5);
		a.set(0, 4);
		Sequence b = new Sequence(5);
		b.set(0, 4);
		Sequence c = new Sequence(5);
		c.set(0, 3);
		Sequence d = new Sequence(4);
		d.set(0, 4);
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.equals(d));
		
		a.set(0, 7);
		a.set(1, 3);
		a.set(2, 6);
		a.set(3, 6);
		a.set(4, 2);
		// a = { 7, 3, 6, 6, 2 }
		d.set(0, 2);
		d.set(1, 3);
		d.set(2, 6);
		d.set(3, 7);
		// d = { 2, 3, 6, 7 }
		
		System.out.println(a.sameValues(d));
	}
}

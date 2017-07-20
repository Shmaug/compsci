import java.util.ArrayList;

public class Sequence {
	private ArrayList<Integer> values;
	
	public Sequence() {
		values = new ArrayList<Integer>();
	}
	public void add(int n) {
		values.add(n);
	}
	public String toString() {
		return values.toString();
	}
	
	public Sequence append(Sequence b){
		Sequence n = new Sequence();
		for (int i = 0; i < values.size(); i++)
			n.add(values.get(i));
		for (int i = 0; i < b.values.size(); i++)
			n.add(b.values.get(i));
		
		return n;
	}
	
	public static void main(String[] args){
		Sequence a = new Sequence();
		a.add(0);
		a.add(1);
		a.add(5);
		Sequence b = new Sequence();
		b.add(3);
		b.add(-5);
		b.add(7);
		
		System.out.println(a.append(b));
		System.out.println(b.append(a));
	}
}

public class FirstDigitDistribution {
	private int[] counters;
	
	public FirstDigitDistribution() {
		counters = new int[10];
	}
	
	public int getDigitCount(int d) {
		return counters[d];
	}
	
	public void process(Sequence seq, int count) {
		for (int i = 1; i <= count; i++){
			int val = seq.next();
			int first = Integer.parseInt(Integer.toString(val).substring(0, 1));
			counters[first]++;
		}
	}
	
	public void display() {
		for (int i = 0; i < counters.length; i++) {
			System.out.println(i + ": " + counters[i]);
		}
	}
	
	
	public static void main(String[] args) {
		  FirstDigitDistribution dist1 = new FirstDigitDistribution();
		  dist1.process(new SquareSequence(), 1000);
		  dist1.display();
		  System.out.println();
		  
		  FirstDigitDistribution dist2 = new FirstDigitDistribution();
	      dist2.process(new RandomSequence(), 1000);
	      dist2.display(); 
	}
}

public class ComboLock {
	private int num1, num2, num3;
	
	private int curNum = 0;
	
	private boolean a,b,c;
	
	public ComboLock(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		a=b=c=false;
	}
	
	public void reset() {
		curNum = 0;
		a=b=c=false;
	}
	
	public void turnLeft(int ticks) {
		curNum -= ticks;
		while (curNum < 0) curNum += 40;
		
		if (a && curNum == num2)
			b = true;
	}
	public void turnRight(int ticks) {
		curNum += ticks;
		while (curNum > 39) curNum -= 40;
		
		if (a && b && curNum==num3)
			c = true;
		if (!a && curNum==num1)
			a = true;
	}
	
	public boolean open() {
		return a && b && c && curNum == num3;
	}
	
	public int getTick() {
		return curNum;
	}
	
	public static void main(String[] args) {
		ComboLock lock = new ComboLock(0,23,7);
		
		lock.turnRight(40);
		lock.turnLeft(17);
		lock.turnRight(24);
		
		System.out.println(lock.open());
		
		lock.reset();
		System.out.println(lock.open());
		
		lock.turnRight(24);
		lock.turnLeft(17);
		lock.turnRight(24);
		System.out.println(lock.open());
	}
}

public class MothTester {
	public static void main(String[] args) {
		Moth m = new Moth(0);
		System.out.println(m.getPosition());
		m.moveToLight(10);
		System.out.println(m.getPosition());
	}
}

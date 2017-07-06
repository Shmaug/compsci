import java.awt.Rectangle;

public class PerimeterTester {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(100, 200);
		double perimeter = 2 * (rect.getWidth() + rect.getHeight());
		System.out.println("100x200 rectangle has a perimeter of " + perimeter + " (expected 600)");
	}
}

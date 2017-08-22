import java.awt.Point;

public class Robot {
	private String direction;
	private Point position;
	
	public Robot() {
		direction = "n";
		position = new Point();
	}
	
	public void turnLeft() {
		switch (direction) {
			case "n":
				direction = "w";
				break;
			case "s":
				direction = "e";
				break;
			case "e":
				direction = "n";
				break;
			case "w":
				direction = "s";
				break;
		}
	}
	public void turnRight() {
		switch (direction) {
			case "n":
				direction = "e";
				break;
			case "s":
				direction = "w";
				break;
			case "e":
				direction = "s";
				break;
			case "w":
				direction = "n";
				break;
		}
	}
	public void move() {
		switch (direction) {
			case "n":
				position.setLocation(position.x, position.y + 1);
				break;
			case "s":
				position.setLocation(position.x, position.y - 1);
				break;
			case "e":
				position.setLocation(position.x + 1, position.y);
				break;
			case "w":
				position.setLocation(position.x - 1, position.y);
				break;
		}
	}
	public Point getLocation() {
		return new Point(position.x, position.y); // dont want to return the actual position object
	}
	public String getDirection() {
		return direction;
	}
	
	public static void main(String[] args) {
		Robot r = new Robot();
		
		System.out.println(r.getLocation() + ", " + r.getDirection());
		for (int i = 0; i < 4; i++){
			r.turnRight();
			r.move();
			System.out.println(r.getLocation() + ", " + r.getDirection());
		}
		for (int i = 0; i < 4; i++){
			r.turnLeft();
			r.move();
			System.out.println(r.getLocation() + ", " + r.getDirection());
		}
	}
}

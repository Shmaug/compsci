import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
	private String name;
	private boolean color = false;
	
	private Board board;
	private Scanner in;
	
	@Override
	public void init(boolean color) {
		this.color = color;
		board = new Board();
		in = new Scanner(System.in);
		
		System.out.print("Enter name for " + (color ? "red" : "yellow") + ": ");
		name = in.nextLine();
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public int move() {
		System.out.println(board);
		System.out.print("Enter move for " + name + " (" + (color ? "red" : "yellow") + ") within 18 seconds: ");

		int input = -1;
		
		while (input == -1) {
			try {
				input = in.nextInt();
			} catch (Exception e) {
				if (e instanceof InputMismatchException)
					continue;
				return -1;
			}
			if (input < 0 || input > 6 || board.isColumnFull(input))
				input = -1;
		}
		
		board.move(input, color);
		return input;
	}

	@Override
	public void inform(int i) {
		board.move(i, !color);
	}
}

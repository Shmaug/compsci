import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static ArrayList<Board> losses = new ArrayList<Board>();
	static Random random = new Random();
	static Board cur, prev;
	static boolean exit = false;
	
	public static void doMove(int space, Space team) {
		prev = cur;
		cur = cur.move(space, team);
	}		
	public static void computerMove() {
		ArrayList<Integer> available = new ArrayList<Integer>();
		ArrayList<Integer> availableAndNotLoss = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++)
			if (cur.getSpace(i) == Space.NONE) {
				available.add(i);
				if (!losses.contains(cur.move(i, Space.X)))
					availableAndNotLoss.add(i);
			}
		
		int mv = -1;
		if (availableAndNotLoss.size() > 0) 
			mv = availableAndNotLoss.get(random.nextInt(availableAndNotLoss.size()));
		else
			mv = available.get(random.nextInt(available.size()));
		doMove(mv, Space.X);
	}
	
	public static void doGame(Scanner in) {
		int input = -1;
		
		while (true) {
			// gather input
			input = -1;
			if (in != null) {
				System.out.println();
				System.out.println(cur);
				
				while (input == -1){
					System.out.print("Enter your move: ");
					try {
						String s = in.nextLine();
						if (s.equals("exit")) {
							exit = true;
							break;
						}
						input = Integer.parseInt(s);
					}catch(Exception e) {
						System.out.println("Input was not a number");
						input = -1;
					}
					if (input != -1)
						if (input < 0 || input > 8 || cur.getSpace(input) != Space.NONE)
							input = -1;
				}
			}else {
				// no scanner; choose random input
				ArrayList<Integer> available = new ArrayList<Integer>();
				for (int i = 0; i < 9; i++)
					if (cur.getSpace(i) == Space.NONE)
						available.add(i);
				input = available.get(random.nextInt(available.size()));
			}
			if (exit) break;
			
			doMove(input, Space.O);
			if (cur.isGameOver())
				break;
			
			computerMove();
			if (cur.isGameOver())
				break;
		}
		if (exit) return;
		
		System.out.println(cur);
		
		switch (cur.getWinner()) {
		case NONE:
			System.out.println("Tie game!");
			break;
		case O:
			System.out.println("You win!");
			losses.add(prev);
			break;
		case X:
			System.out.println("You lose!");
			break;
		}
	}
	
	public static void main(String[] args) {
		cur = new Board();
		
		int train = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter number of training games: ");
		if (in.hasNextInt()) {
			train = in.nextInt();
			
			for (int i = 0; i < train; i++) {
				cur = new Board();
				prev = null;
				
				doGame(null);
			}
		}

		exit = false;
		while (!exit) {
			cur = new Board();
			prev = null;
			System.out.println(losses.size() + " learnt games");
			
			doGame(in);
		}
		
		in.close();
	}
}

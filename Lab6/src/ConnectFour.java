import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ConnectFour {
	static int move = -1;
	static Random random = new Random();
	
	static void doMove(Board board, Player p1, Player p2, boolean color) {
		move = -1;
		Thread mvThread = new Thread() {
			public void run() {
				try {
					move = p1.move();
				}catch (Exception e) {
					move = -1;
				}
			}
		};
		mvThread.start();
		
		int time = 18000;
		while (time > 0 && move == -1){
			try {
				time -= 100;
				Thread.sleep(100);
			} catch (InterruptedException e) { }
		}
		
		if (time <= 0){
			mvThread.interrupt();
			
			System.out.println("\nTime up! Picking random slot...");
			ArrayList<Integer> available = new ArrayList<Integer>();
			for (int i = 0; i < 7; i++)
				if (!board.isColumnFull(i))
					available.add(i);
			move = available.get(random.nextInt(available.size()));
		}
		
		p2.inform(move);
		board.move(move, color);
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Player p1, p2;
		
		int mode = 0;
		System.out.println("Enter mode\n0: human vs human\n1: human vs computer");
		mode = in.nextInt();
		if (mode == 0) {
			p1 = new HumanPlayer();
			p2 = new HumanPlayer();
		}else if (mode == 1){
			p1 = new HumanPlayer();
			p2 = new AIPlayer();
		}else {
			System.out.println("Invalid mode.");
			in.close();
			return;
		}
		
		p1.init(true);
		p2.init(false);
		
		Board board = new Board();
		
		move = 0;
		
		while (true) {
			doMove(board, p1, p2, true);
			if (board.checkGameOver()) break;
			
			doMove(board, p2, p1, false);
			if (board.checkGameOver()) break;
		}
		System.out.println(board);
		System.out.println(board.getWinner() + " wins!");
		
		in.close();
	}
}

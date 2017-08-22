import java.util.ArrayList;
import java.util.Random;

public class AIPlayer implements Player {
	private final int gameScore = 100000; // winning game score for minimax algorithm (should be infinity, close enough)
	
	private String name;
	private boolean color;
	
	private Board board;
	
	private Random random = new Random();
	
	@Override
	public void init(boolean color) {
		name = "Computer";
		this.color = color;
		board = new Board();
	}

	@Override
	public String name() {
		return name;
	}
	
	public boolean isWinningMove(Board b, int i) {
		Board c = b.copy();
		c.move(i, color);
		if (c.checkGameOver() && c.hasWinner())
			return true;
		
		return false;
	}

	int scorePosition(Board b, int x, int y, int dy, int dx) {
		int mypts = 0;
		int otherpts = 0;
		
		byte mybcol = (byte) (color ? 1 : 2);
		byte otherbcol = (byte) (color ? 2 : 1);
		for (int i = 0; i < 4; i++) {
			if (b.getColor(x, y) == mybcol)
				mypts++;
			else if (b.getColor(x , y) == otherbcol)
				otherpts++;
			x += dx;
			y += dy;
		}
		
		if (otherpts >= 4)
			return -gameScore; // this position has a victory in the direction (dx, dy)
		else if (mypts >= 4)
			return gameScore; // this position has a victory in the direction (dx, dy)
		else
			return mypts;
	}
	
	int scoreBoard(Board b) {
		int points = 0;
		
		int score; // tmp variable
		
		// vertical check
		for (int x = 0; x < 7; x++)
			for (int y = 0; y < 3; y++) { // only go down to y<3 because scorePosition scans down 4 slots
				score = scorePosition(b, x, y, 1, 0);
				if (score == gameScore || score == -gameScore) return score; // found a winner, exit early
				points += score;
			}
		
		// horizontal check
		for (int x = 0; x < 4; x++) // only go across to x<4 because scorePosition scans across 4 slots
			for (int y = 0; y < 6; y++) {
				score = scorePosition(b, x, y, 0, 1);
				if (score == gameScore || score == -gameScore) return score; // found a winner, exit early
				points += score;
			}
		
		// ascending diagonal check
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 3; y++) { // stop at x<4 and y<3 because scorePosition scans 4 slots
				score = scorePosition(b, x, y, 1, 1);
				if (score == gameScore || score == -gameScore) return score; // found a winner, exit early
				points += score;
			}
		
		// descending diagonal check
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 3; y++) { // stop at x<4 and y<3 because scorePosition scans 4 slots
				score = scorePosition(b, x, y, -1, 1);
				if (score == gameScore || score == -gameScore) return score; // found a winner, exit early
				points += score;
			}
		
		return points;
	}
	
	int[] minimizePlay(Board b, int depth) {
		int score = scoreBoard(b);
		
		if (depth == 0 || score == gameScore || score == -gameScore) // this board was a winner already
			return new int[] { -1, score };
		
		int[] min = {-1, gameScore-1};

		for (int x = 0; x < 7; x++) {
			if (!b.isColumnFull(x)) {
				Board nb = b.copy();
				// switch color here, simulating other player
				nb.move(x, !color); // simulate moving to this slot, and evaluate the board
				
				int[] cur = maximizePlay(nb, depth - 1);
				
				if (min[0] == -1 || cur[1] < min[1]) { // find smallest score
					min[0] = x;
					min[1] = cur[1];
				}
			}
		}
		
		return min;
	}
	
	int[] maximizePlay(Board b, int depth) {
		int score = scoreBoard(b);
		
		if (depth == 0 || score == gameScore || score == -gameScore) // someone already won, or we're out of depth
			return new int[] { -1, score };
		
		int[] max = {-1, -gameScore+1};
		
		for (int x = 0; x < 7; x++) {
			if (!b.isColumnFull(x)) {
				Board nb = b.copy();
				nb.move(x, color); // simulate moving to this slot, and evaluate the board
				
				int[] cur = minimizePlay(nb, depth - 1);
				
				if (max[0] == -1 || cur[1] > max[1]) { // find biggest score
					max[0] = x;
					max[1] = cur[1];
				}
			}
		}
		
		return max;
	}
	
	int minimax() {
		// very butchered minimax algorithm I spliced together after a few hours of reading
		// and reading a couple different implementations of it in various languages
		
		// I'm not actually sure if this is as smart as it should be
		// but it kind of makes sense since this is the most basic of the
		// AI algorithms out there
		
		int[] move = maximizePlay(board, 4); // IF THE AI TURN TAKES TOO LONG, DECREASE THE NUMBER HERE (SEARCH DEPTH)

		if (move[0] == -1) {
			System.out.println("AI: Picking random slot...");
			// return random open column if no good move found
			ArrayList<Integer> open = new ArrayList<Integer>();
			for (int i = 0; i < 7; i++)
				if (!board.isColumnFull(i))
					open.add(i);
			return open.get(random.nextInt(open.size()));
		}
		
		return move[0];
	}

	@Override
	public int move() {
		int input = minimax();
		
		board.move(input, color);
		return input;
	}

	@Override
	public void inform(int i) {
		board.move(i, !color);
	}
}

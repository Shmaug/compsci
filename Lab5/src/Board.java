
public class Board {
	private boolean gameOver;
	private Space winner;
	
	private Space[] spaces;
	
	public Board() {
		gameOver = false;
		spaces = new Space[9];
		for (int i = 0; i < 9; i++)
			spaces[i] = Space.NONE;
	}

	public Board copy() {
		Board n = new Board();
		for (int i = 0; i < 9; i++)
			n.spaces[i] = spaces[i];
		return n;
	}
	public Board move(int space, Space val) {
		Board b = copy();
		b.spaces[space] = val;
		b.checkWin();
		return b;
	}
	
	public Space getSpace(int i) {
		return spaces[i];
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	public Space getWinner() {
		return winner;
	}
	
	// returns false when there are empty spaces and no winner
	public boolean checkWin() {
		// 1st diagonal (0, 4, 8)
		if (spaces[0] != Space.NONE && spaces[0] == spaces[4] && spaces[0] == spaces[8]) {
			winner = spaces[0];
			gameOver = true;
			return true;
		}
		// 2nd diagonal (2, 4, 6)
		if (spaces[2] != Space.NONE && spaces[2] == spaces[4] && spaces[2] == spaces[6]) {
			winner = spaces[2];
			gameOver = true;
			return true;
		}
				
		for (int x = 0; x < 3; x++) {
			// rows
			if (spaces[3*x] != Space.NONE && spaces[3*x] == spaces[3*x + 1] && spaces[3*x] == spaces[3*x + 2]) {
				winner = spaces[3*x];
				gameOver = true;
				return true; // horizontal victory
			}
			
			// columns
			if (spaces[x] != Space.NONE && spaces[x] == spaces[x + 3] && spaces[x] == spaces[x + 6]) {
				winner = spaces[x];
				gameOver = true;
				return true; // vertical victory
			}
		}
		
		for (int i = 0; i < 9; i++)
			if (spaces[i] == Space.NONE)
				return false;
		
		gameOver = true;
		winner = Space.NONE;
		return true; // tie
	}
	
	public String toString() {
		String str = 
				  "* | * | * \n"
				+ "* | * | * \n"
				+ "* | * | *";
		for (int i = 0; i < 9; i++)
			str = str.replaceFirst("[*]", spaces[i] == Space.X ? "X" : (spaces[i] == Space.O ? "O" : i + ""));
		return str;
	}
	public boolean equals(Object o) {
		if (!(o instanceof Board)) return false;
		Board b = (Board)o;
		for (int i = 0; i < 9; i++)
			if (b.getSpace(i) != getSpace(i))
				return false;
		return true;
	}

}

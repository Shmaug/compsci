public class Board {
	byte winner = 0;//0=nobody, 1=red, 2=yellow
	byte[][] board; //0=empty, 1=red, 2=yellow
	
	public Board() {
		board = new byte[7][6];
	}
	
	public boolean isColumnFull(int slot) {
		return board[slot][0] != 0;
	}
	
	public void move(int slot, boolean color) {
		for (int y = 5; y >= 0; y--)
			if (board[slot][y] == 0) {
				board[slot][y] = (byte) (color ? 1 : 2);
				return;
			}
	}
	
	public byte getColor(int x, int y) {
		if (x < 0 || x > 6 || y < 0 || y > 5)
			return 0;
		return board[x][y];
	}
	
	public Board copy() {
		Board c = new Board();
		for (int x = 0; x < 7; x++)
			for (int y = 0; y < 6; y++)
				c.board[x][y] = board[x][y];
		return c;
	}
	
	private boolean checkHorizontal() {
		for (int y = 0; y < 6; y++) {
			byte color = 0;
			byte cur = 0;
			for (int x = 0; x < 7; x++) {
				if (board[x][y] == color) {
					cur++;
					if (color != 0 && cur >= 4) {
						winner = color;
						return true;
					}
				}else {
					color = board[x][y];
					cur = 1;
				}
			}
		}
		return false;
	}
	private boolean checkVertical() {
		for (int x = 0; x < 7; x++) {
			byte color = 0;
			byte cur = 0;
			for (int y = 0; y < 6; y++) {
				if (board[x][y] == color) {
					cur++;
					if (color != 0 && cur >= 4) {
						winner = color;
						return true;
					}
				}else {
					color = board[x][y];
					cur = 1;
				}
			}
		}
		return false;
	}
	private boolean checkAscendingDiagonal() {
		byte color = 0;
		byte cur = 0;

		for (int i = 0; i < 6; i++) { // check down the left side of the board
			color = 0;
			cur = 0;
			
			for (int x = 0, y = i;
					x < 7 && y < 6;
					x++, y++) {
				if (board[x][y] == color) {
					cur++;
					if (color != 0 && cur >= 4) {
						winner = color;
						return true;
					}
				}else {
					color = board[x][y];
					cur = 1;
				}
			}
		}
		for (int i = 0; i < 7; i++) { // check across the top of the board
			color = 0;
			cur = 0;
			
			for (int x = i, y = 0;
					x < 7 && y < 6;
					x++, y++) {
				if (board[x][y] == color) {
					cur++;
					if (color != 0 && cur >= 4) {
						winner = color;
						return true;
					}
				}else {
					color = board[x][y];
					cur = 1;
				}
			}
		}
		
		return false;
	}
	private boolean checkDescendingDiagonal() {
		byte color = 0;
		byte cur = 0;

		for (int i = 0; i < 6; i++) { // check down the left side of the board
			color = 0;
			cur = 0;
			
			for (int x = 6, y = i;
					x >= 0 && y < 6;
					x--, y++) {
				if (board[x][y] == color) {
					cur++;
					if (color != 0 && cur >= 4) {
						winner = color;
						return true;
					}
				}else {
					color = board[x][y];
					cur = 1;
				}
			}
		}
		for (int i = 0; i < 7; i++) { // check across the top of the board
			color = 0;
			cur = 0;
			
			for (int x = i, y = 0;
					x >= 0 && y < 6;
					x--, y++) {
				if (board[x][y] == color) {
					cur++;
					if (color != 0 && cur >= 4) {
						winner = color;
						return true;
					}
				}else {
					color = board[x][y];
					cur = 1;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkGameOver() {
		winner = 0;
		
		//check if no slots empty
		boolean full = true;
		for (int x = 0; x < 7; x++)
			if (!isColumnFull(x)) {
				full = false;
				break;
			}
		if (full) return true;
		
		if (checkHorizontal()) {
			System.out.println("horizontal victory");
			return true;
		}
		if (checkVertical()) {
			System.out.println("vertical victory");
			return true;
		}
		if (checkAscendingDiagonal()) {
			System.out.println("ascending diagonal victory");
			return true;
		}
		if (checkDescendingDiagonal()) {
			System.out.println("descending diagonal victory");
			return true;
		}
		return false;
	}
	public String getWinner() {
		if (winner == 1) return "red";
		if (winner == 2) return "yellow";
		return "nobody";
	}

	public boolean hasWinner() {
		return winner != 0;
	}
	
	public String getDisplay(byte v) {
		if (v == 1) return "X";
		if (v == 2) return "O";
		return "-";
	}
	
	public String toString() {
		String str = "";
		for (int x = 0; x < 7; x++)
			str += x + " ";
		str += "\n";
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 7; x++)
				str += getDisplay(board[x][y]) + " ";
			
			str += "\n";
		}
		
		return str;
	}
}

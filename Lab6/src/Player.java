public interface Player {
	void init(boolean color);
	String name();
	int move();
	void inform(int i);
}
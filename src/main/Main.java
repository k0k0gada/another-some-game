package main;

public class Main {

	private static final int MAX_PLAYERS = 4;// after beta should inc. and min
												// board size should depend on
												// number of players
	private static final int MIN_PLAYERS = 2;

	public static void main(String[] args) {
		Play();
	}

	private static void Play() {
		Board board = new Board();
		int n;
		do {
			System.out.println("how many players do you want?(between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ")");
			n = Board.sc.nextInt();
		} while (n < MIN_PLAYERS || n > MAX_PLAYERS);
	}
}

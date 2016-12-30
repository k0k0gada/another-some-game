package players;

import java.util.ArrayList;

import main.Main;

public class Player {
	private static final int MAX_PLAYERS = 4;// after beta should inc. and min
	// board size should depend on
	// number of players
	private static final int MIN_PLAYERS = 2;

	boolean human;
	String name;
	char symbol;
	ArrayList<Units> army = new ArrayList<Units>();

	public Player() {
		System.out.println("will this player be ");
	}

	public static int numPlayers() {
		int n;
		do {
			System.out.println("how many players do you want?(between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ")");
			n = Main.sc.nextInt();
		} while (n < MIN_PLAYERS || n > MAX_PLAYERS);
		return n;
	}
}

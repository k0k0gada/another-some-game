package players;

import java.util.ArrayList;

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
}

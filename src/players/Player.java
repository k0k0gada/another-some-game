package players;

import java.util.ArrayList;
import java.util.HashSet;

import main.Main;

public class Player {
	private static final int MAX_PLAYERS = 4;// after beta should inc. and min
	// board size should depend on
	// number of players
	private static final int MIN_PLAYERS = 2;

	boolean human;
	String name;
	Character symbol;
	ArrayList<Units> army = new ArrayList<Units>();

	public String getName() {
		return name;
	}

	public Player() {
		System.out.println("will this player be human//only human players for now.. ");
		human = Main.yesNoDecision();
		name = setPlayerName();
		symbol = setPlayerSign();

	}

	private char setPlayerSign() {
		Character c;
		HashSet<Character> usedSigns = new HashSet<Character>();
		// add here (with usedSigns.add) characters used by the game
		do {
			System.out.println("what will your sign be ?");
			c = Main.sc.nextLine().charAt(0);
			if (!usedSigns.contains(c)) {
				System.out.println("character for player " + name + " is set to " + c);
				break;
			} else {
				System.err.println("character for player " + name + " is not set.!!set again!!");
			}
		} while (true);
		return c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Character getSymbol() {
		return symbol;
	}

	static String setPlayerName() {
		// System.out.println();
		System.out.println("minimum 3 characters long! Only letters; digits; and ',' ; '.' ; '-' ; '_' allowed");
		String name;
		boolean nameOK;
		do {
			nameOK = true;
			System.out.println("enter Player's name: ");
			name = Main.sc.nextLine();
			if (name.length() < 3) {
				System.out.println("less then 3 characters !try again!");
				nameOK = false;
				continue;
			}
			for (int i = 0; i < name.length(); i++) {
				Character c = name.charAt(i);
				if (Character.isLetterOrDigit(c)) {
					continue;
				} else {
					if (c == ',' || c == '.' || c == '-' || c == '_') {
						continue;
					} else {
						nameOK = false;
						System.out.println("the character " + c + " is not allowed!try again!");
						break;
					}
				}
			}
		} while (!nameOK);
		System.out.println("Player's name set to " + name);
		return name;
	}

	@Override
	public String toString() {
		return "Player [human=" + human + ", name=" + name + ", symbol=" + symbol + "]";
	}

	public static int numPlayers() {
		int n;
		do {
			System.out.println("how many players do you want?(between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ")");
			n = Main.sc.nextInt();
		} while (n < MIN_PLAYERS || n > MAX_PLAYERS);
		Main.sc.nextLine();
		return n;
	}
}

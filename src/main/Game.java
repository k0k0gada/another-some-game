package main;

import java.util.Set;
import java.util.TreeSet;

import players.Player;

public class Game {
	static Board board;
	Set<Player> Players = new TreeSet<Player>();

	public static void mainMenu() {
		System.out.println("1(ng).new game;2(b).boards;");
		String temp = Main.sc.nextLine();
		Main.sc.nextLine();
		String[] options = { "1", "ng", "new game", "2", "b", "boards", "o", };
		for (int i = 0; i < options.length; i++) {
			if (temp.equals(options[i]) || temp.startsWith(options[i])) {

				temp = options[i];
				break;
			}
			if (i == options.length - 2) {
				temp = options[options.length - 1];
				break;
			}
		}
		switch (temp) {
		case "1":
		case "ng":
		case "new game":
			Player.numPlayers();
			break;
		case "2":
		case "b":
		case "boards":
			board = new Board();
			break;
		case "o":

			break;

		}
	}
}

package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import players.Player;
import players.comparatorName;
import players.comparatorSign;

public class Game {
	Board board;
	private int numberOfPlayers;
	TreeSet<Player> playersSign;
	TreeSet<Player> playersName;
	ArrayList<Player> players = new ArrayList<>();
	HashSet<Board> availableBoards = new HashSet<Board>();
	String name;

	public Game() {
		numberOfPlayers = Player.numPlayers();
		playersSign = new TreeSet<Player>(new comparatorSign());
		playersName = new TreeSet<Player>(new comparatorName());
		setPlayers();
		board = new Board();
		// board=Board.boardSelection();
	}

	private void setPlayers() {
		int n = players.size();
		do {
			Player p = new Player();
			if (!playersSign.add(p)) {
				System.err.println("sign already selected!use another!");
				continue;
			}
			if (!playersName.add(p)) {
				System.err.println("Name already selected!use another");
				playersSign.remove(p);
				continue;

			}
			System.out.println("player " + p.getName() + " added succesfully");
			players.add(p);
			n = players.size();
		} while (n < numberOfPlayers);
		System.out.println(players.toString());
	}

	public static void mainMenu() {
		System.out.println("1(ng).new game;   2(b).boards;");
		String temp = Main.sc.nextLine();
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
			Main.play();
			break;
		case "2":
		case "b":
		case "boards":
			new Board();
			break;
		case "o":
			mainMenu();
			break;

		}
	}
}

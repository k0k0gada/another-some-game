package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import comparators.comparatorName;
import comparators.comparatorSign;
import players.Player;

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
		if (Board.boards.isEmpty()) {
			board = new Board();
		} else {
			System.out.println("choose (n/nb)new board or (number)already existing one:");
			Board.showAvailableBoards();
			System.out.println("new board");
			String temp = Main.sc.nextLine();
			int n;
			if (temp.length() > 0 && Character.isDigit(temp.charAt(0))) {
				n = temp.charAt(0);
				if (Board.boards.size() > 9 && temp.length() > 1 && Character.isDigit(temp.charAt(1))) {
					n = n * 10 + temp.charAt(1);
					if (Board.boards.size() > 99 && temp.length() > 2 && Character.isDigit(temp.charAt(2))) {
						n = n * 10 + temp.charAt(2);
					}
				}
			} else if (temp.length() == 0 || temp.startsWith("n") || temp.startsWith("nb")) {
				board = new Board();
			}
		} // board=Board.boardSelection();
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

	public void setStartLocations() {
		for (Iterator<Player> it = players.iterator(); it.hasNext();) {
			Player pl = (Player) it.next();
			pl.setStartLocation();
		}
	}
}

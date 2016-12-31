package main;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	HashSet<Board> boards;

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		Game.mainMenu();
	}

	public static boolean yesNoDecision() {
		System.out.println("!!!!!\ty/enter=yes;else=no;\t!!!!!");
		String s = sc.nextLine();
		s = s.toLowerCase();
		if (s.length() == 0) {
			return true;
		}
		if (s.charAt(0) != 'y') {
			return false;
		}
		return true;
	}

	public static void play() {
		Game game = new Game();
		
	}
}
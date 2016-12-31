package main;

public class Board {
	private static final int MAX_SIZE = 15;
	// max size should increase !
	private static final int MIN_SIZE = 4;

	String[][] board;

	public Board() {
		System.out.println("what kind of board do you want?");
		System.out.println("s-square");// may be rectangle form of board..
		String[] boards = { "s", "o" };
		String temp = Main.sc.next();
		for (int i = 0; i < boards.length; i++) {
			if (temp.startsWith(boards[i])) {
				temp = boards[i];
				break;
			}
			if (i == boards.length - 2) {
				temp = boards[boards.length - 1];
				break;
			}
		}
		switch (temp) {
		case "s":
		case "o":// when other kinds of boards there are ;you should move the"o"
					// case last
			int size;
			do {
				System.out.println("what board size do you want?(between " + MIN_SIZE + " and " + MAX_SIZE + ")");
				size = Main.sc.nextInt();
			} while (size < MIN_SIZE || size > MAX_SIZE);
			board = new String[size + 2][size + 1];
			setBasicBoard(board);
			showBoard();
		}
	}

	public void showBoard() {
		String tireta = "-------";
		String ravnota = "=======";
		for (int j = 1; j < board[0].length; j++) {
			tireta += "-------";
			ravnota += "=======";
		}
		for (int i = 0; i < board.length; i++) {
			System.out.println(tireta);
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println(ravnota);
	}

	private void setBasicBoard(String[][] board) {
		// remove nulls
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "    ";
				if (j == 0) {
					board[i][j] = "   ";
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0) {
					if (j == 0) {
						j = 1;
					}
					if (j < 10) {
						board[i][j] = " " + j + "  ";
					} else if (j < 100) {// if MAX_SIZE >100 SHOULD ADD MORE
						board[i][j] = " " + j + " ";
					} else {// for j>100
						board[i][j] = " " + j;
					}
				}
				if (i == 1) {
					if (j == 0) {
						j = 1;
					}
					char bukva = (char) ('a' + j - 1);
					if (j < 27) {
						board[i][j] = " " + bukva + "  ";
					} else {
						char bukva1 = (char) ('a' + ((j - 1) / 26));
						char bukva2 = (char) ('a' + ((j - 1) % 26));
						board[i][j] = " " + bukva1 + bukva2 + " ";
					}
				}
				if (i > 1) {
					if (j == 0) {
						if (i < 11) {
							board[i][j] = (i - 1) + "  ";
						} else if (i < 101) {
							board[i][j] = (i - 1) + " ";
						} else {
							board[i][j] = Integer.toString(i - 1);
						}
					}
				}
			}
		}
	}
}

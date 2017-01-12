package comparators;

import java.util.Comparator;

import players.Player;

public class comparatorSign implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getSymbol().compareTo(o2.getSymbol());
	}

}

package comparators;

import java.util.Comparator;

import players.Player;

public class comparatorName implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

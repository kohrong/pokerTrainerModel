package table;

import java.util.ArrayList;

public class Pot {
	private int totalPot;
	
	public Pot(int sB, int bB, int ante, ArrayList<PokerPlayer> pokerPlayerList) {
		super();
		totalPot = sB + bB + (ante*pokerPlayerList.size());
	}
	
	public int getTotalPot() {
		return totalPot;
	}	
	
}

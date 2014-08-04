package table;

import pokertrainer.PokerHand;
import pokertrainer.TexasHand;

public class PokerPlayer {
	private String name;
	private Stack stack;
	private TablePosition position;
	private TexasHand holeCards;
	private PokerHand pokerHand;
	private PlayerStatus status;

	public PokerPlayer(String name, Stack stack, TablePosition position,
			TexasHand holeCards) {
		super();
		this.name = name;
		this.stack = stack;
		this.position = position;
		this.holeCards = holeCards;
	}

	public String getName() {
		return this.name;
	}

	public Stack getStack() {
		return stack;
	}

	public void setStack(Stack stack) {
		this.stack = stack;
	}

	public TablePosition getPosition() {
		return position;
	}

	public void setPosition(TablePosition position) {
		this.position = position;
	}

	public PokerHand getPokerHand() {
		return pokerHand;
	}

	public void setPokerHand(PokerHand pokerHand) {
		this.pokerHand = pokerHand;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TexasHand getTexasHand() {
		return holeCards;
	}

	public void setTexasHand(TexasHand texasHand) {
		this.holeCards = texasHand;
	}
}

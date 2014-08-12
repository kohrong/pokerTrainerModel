package table;

import pokerPlayerStatus.PlayerStatus;
import pokertrainer.PokerHand;
import pokertrainer.TexasHand;

public class PokerPlayer {
	private String name;
	private Stack stack;
	private TablePosition position;
	private TexasHand holeCards;
	private PokerHand pokerHand;
	private PlayerStatus status;
	private TableView tableView;
	private int bet;

	public PokerPlayer(String name, Stack stack, TablePosition position,
			TexasHand holeCards, TableView tableView) {
		super();
		this.name = name;
		this.stack = stack;
		this.position = position;
		this.holeCards = holeCards;
		this.tableView = tableView;
		this.bet = 0;
		calculatePokerHand();
	}

	private void calculatePokerHand() {
		PokerHandCalculator boardChecker = new PokerHandCalculator();
		pokerHand = boardChecker.calculatePokerHand(holeCards, tableView.getBoard());	
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

	public PlayerStatus getStatus() {
		return status;
	}

	public void setStatus(PlayerStatus status) {
		this.status = status;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	
}

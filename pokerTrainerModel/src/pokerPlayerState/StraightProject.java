package pokerPlayerState;

import java.util.ArrayList;

import cardListAttributesChecker.CardsConnectedChecker;
import pokertrainer.Card;
import pokertrainer.TexasHand;
import table.Board;
import table.PokerHandCalculator;

public class StraightProject {
	private Board board;
	private TexasHand texasHand;
	private PokerHandCalculator pokerHandCalculator;
	
	public StraightProject(Board board, TexasHand texasHand) {
		super();
		this.board = board;
		this.texasHand = texasHand;
		pokerHandCalculator = new PokerHandCalculator();
	}
	
	public boolean isStraightProject(){
		if(board.isRiver() || board.isPreFlop())
			return false;
		else if(pokerHandCalculator.calculatePokerHand(texasHand, board).isStraight())
			return false;
		else
			return new CardsConnectedChecker().check(createSequence(), 4);
	}
	
	private ArrayList<Card> createSequence() {
		ArrayList<Card> sequence = new ArrayList<>();
		sequence.add(texasHand.getCard0());
		sequence.add(texasHand.getCard1());
		for(int i = 0; i < board.size(); i++)	sequence.add(board.get(i));
		return sequence;
	}
}

package pokerPlayerStatus;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.TexasHand;
import table.Board;
import table.BoardChecker;
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
			return calculateStraightProject();
	}
	
	private boolean calculateStraightProject() {
		ArrayList<Card> sequence = new ArrayList<>();
		
		sequence.add(texasHand.getCard0());
		sequence.add(texasHand.getCard1());
		sequence.add(board.getFlop()[0]);
		sequence.add(board.getFlop()[1]);
		sequence.add(board.getFlop()[2]);

		if(board.isFlop())
			return new BoardChecker().straightProjectWithFiveCards(sequence);
		if (board.isTurn()){
			sequence.add(board.getTurn());
			return new BoardChecker().straightProjectWithSixCards(sequence);
		}
		return false;
	}
}

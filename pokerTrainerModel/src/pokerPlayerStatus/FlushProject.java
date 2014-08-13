package pokerPlayerStatus;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.TexasHand;
import table.Board;
import table.BoardChecker;
import table.PokerHandCalculator;

public class FlushProject {
	private Board board;
	private TexasHand texasHand;
	private PokerHandCalculator pokerHandCalculator;
	
	public FlushProject(Board board, TexasHand texasHand) {
		super();
		this.board = board;
		this.texasHand = texasHand;
		pokerHandCalculator = new PokerHandCalculator();
	}
	
	public boolean isFlushProject(){
		if(board.isRiver() || board.isPreFlop())
			return false;
		else if(pokerHandCalculator.calculatePokerHand(texasHand, board).isFlush())
			return false;
		return calculateFlushProject();
	}
	
	private boolean calculateFlushProject() {
		ArrayList<Card> sequence = new ArrayList<>();
		sequence.add(texasHand.getCard0());
		sequence.add(texasHand.getCard1());
		for(int i = 0; i < board.size(); i++)	sequence.add(board.get(i));
		return new BoardChecker().sameSuit(sequence, 4);	
	}
}

package pokerPlayerStatus;

import pokertrainer.CardSuit;
import pokertrainer.TexasHand;
import table.Board;
import table.BoardChecker;

public class FlushProject {
	private Board board;
	private TexasHand texasHand;
	private BoardChecker boardChecker;
	
	public FlushProject(Board board, TexasHand texasHand) {
		super();
		this.board = board;
		this.texasHand = texasHand;
		boardChecker = new BoardChecker();
	}
	
	public boolean isFlushProject(){
		if(board.isRiver() || board.isPreFlop())
			return false;
		else if(boardChecker.calculatePokerHand(texasHand, board).isFlush())
			return false;
		else if(texasHand.isSuited())
			return calculateFlushProject(texasHand.getCard0().getSuit(), 2);
		else
			return calculateFlushProject(texasHand.getCard0().getSuit(), 3)
					|| calculateFlushProject(texasHand.getCard1().getSuit(), 3);
	}
	
	private boolean calculateFlushProject(CardSuit suit, int cardsSuited) {
		int sameSuit = 0;
		
		for (int i = 0; i < 3; i++) {
			if(board.getFlop()[i].isSameSuit(suit))
				sameSuit++;
		}
		if(board.isTurn()){
			if(board.getTurn().isSameSuit(suit))
				sameSuit++;
		}
		return sameSuit == cardsSuited;
	}
}

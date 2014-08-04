package table;

import pokerCategory.HandCategory;
import pokertrainer.CardSuit;

public class PlayerStatus {
	
	public float calculateBlinds(int BB, PokerPlayer pokerPlayer){
		return pokerPlayer.getStack().getChips()/BB;
	}
	
	public boolean calculateFlushProject(Board board, PokerPlayer pokerPlayer){
		if(board.getStreet() > 2)
			return false;
		if(pokerPlayer.getPokerHand().getHandCategory() == HandCategory.Flush)
			return false;
		if(pokerPlayer.getTexasHand().isSuited())
			return isFlushProject(pokerPlayer.getTexasHand().getCard0().getSuit(), board, 2);
		else
			return isFlushProject(pokerPlayer.getTexasHand().getCard0().getSuit(), board, 3)
					|| isFlushProject(pokerPlayer.getTexasHand().getCard1().getSuit(), board, 3);
	}

	private boolean isFlushProject(CardSuit suit, Board board, int cardsSuited) {
		int sameSuit = 0;
		
		for (int i = 0; i < 3; i++) {
			if(board.getFlop()[i].isSameSuit(suit))
				sameSuit++;
		}
		if(board.getStreet() == 2){
			if(board.getTurn().isSameSuit(suit))
				sameSuit++;
		}
		return sameSuit == cardsSuited;
	}
	
}

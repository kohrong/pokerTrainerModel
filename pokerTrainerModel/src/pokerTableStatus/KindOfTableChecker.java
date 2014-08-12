package pokerTableStatus;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.CardSuit;
import table.Board;
import table.BoardChecker;

public class KindOfTableChecker {
	
	public KindOfTable checkKindOfTable(Board board){
		if(isExtremelyCoordinated(board))	return KindOfTable.ExtremelyCoordinated;
		if(isCoordinated(board))	return KindOfTable.Coordinated;
		if(isHalfCoordinated(board))	return KindOfTable.HalfCoordinated;
		return KindOfTable.Dry;
	}

	private boolean isHalfCoordinated(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isCoordinated(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isExtremelyCoordinated(Board board) {
		if(board.isPreFlop() || board.isFlop())	return false;
		
		if(fourOfTheSameSuit(board))	return true;
		
		ArrayList<Card> sequence = new ArrayList<>();
		sequence.add(board.getFlop()[0]);
		sequence.add(board.getFlop()[1]);
		sequence.add(board.getFlop()[2]);
		sequence.add(board.getTurn());

		if(board.isTurn())	return new BoardChecker().straightProjectWithFourCards(sequence);
		if(board.isRiver()){
			sequence.add(board.getRiver());
			return new BoardChecker().straightProjectWithFiveCards(sequence);
		}
		return false;
	}

	private boolean fourOfTheSameSuit(Board board) {
		int sameSuit = 0;
		
		for(int i = 0; i < CardSuit.SUITS.length; i++){
			for(int j = 0; j < board.size(); j++){
				if(board.get(j).isSameSuit(CardSuit.SUITS[i]))	sameSuit++;
			}
			if(sameSuit == 4)	return true;
			sameSuit = 0;
		}
		return false;
	}
}

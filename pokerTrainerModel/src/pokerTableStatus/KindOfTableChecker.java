package pokerTableStatus;

import java.util.ArrayList;

import pokertrainer.Card;
import table.Board;
import table.BoardChecker;

public class KindOfTableChecker {
	
	public KindOfTable getKindOfTable(Board board){
		if(isExtremelyCoordinated(board))	return KindOfTable.ExtremelyCoordinated;
		if(isCoordinated(board))	return KindOfTable.Coordinated;
		return KindOfTable.Dry;
	}
	
	public boolean isDry(Board board){
		if(isExtremelyCoordinated(board) || isCoordinated(board))	return false;
		return true;
	}

	public boolean isHalfCoordinated(Board board) {
		if(isExtremelyCoordinated(board) || isCoordinated(board))	return false;
		if(board.isPreFlop())	return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++)	sequence.add(board.get(i));
		
		if(new BoardChecker().sameSuit(sequence, 2))	return new BoardChecker().closestCardsGap(sequence, 4);
		else	return new BoardChecker().closestCardsGap(sequence, 3);
	}

	public boolean isCoordinated(Board board) {
		if(board.isPreFlop() || isExtremelyCoordinated(board)) return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++) sequence.add(board.get(i));
		
		if(new BoardChecker().sameSuit(sequence, 3))	return true;
		return new BoardChecker().isStraightProject(sequence, 3);
	}

	public boolean isExtremelyCoordinated(Board board) {
		if(board.isPreFlop() || board.isFlop())	return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++) sequence.add(board.get(i));

		if(new BoardChecker().sameSuit(sequence, 4))	return true;
		return new BoardChecker().isStraightProject(sequence, 4);
	}

}

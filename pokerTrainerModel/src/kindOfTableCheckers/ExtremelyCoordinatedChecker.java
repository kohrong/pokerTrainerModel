package kindOfTableCheckers;

import java.util.ArrayList;

import pokertrainer.Card;
import table.Board;
import table.BoardChecker;

public class ExtremelyCoordinatedChecker implements KindOfTableChecker{
	
	@Override
	public boolean check(Board board) {
		return isExtremelyCoordinated(board);
	}
	
	public boolean isExtremelyCoordinated(Board board) {
		if(board.isPreFlop() || board.isFlop())	return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++) sequence.add(board.get(i));

		if(new BoardChecker().sameSuit(sequence, 4))	return true;
		return new BoardChecker().isStraightProject(sequence, 4);
	}
}

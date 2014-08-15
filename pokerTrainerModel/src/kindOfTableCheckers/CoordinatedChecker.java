package kindOfTableCheckers;

import java.util.ArrayList;

import pokertrainer.Card;
import table.Board;
import table.BoardChecker;

public class CoordinatedChecker implements KindOfTableChecker{

	@Override
	public boolean check(Board board) {
		return isCoordinated(board);
	}

	public boolean isCoordinated(Board board) {
		if(board.isPreFlop() || new ExtremelyCoordinatedChecker().isExtremelyCoordinated(board)) return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++) sequence.add(board.get(i));
		
		if(new BoardChecker().sameSuit(sequence, 3))	return true;
		return new BoardChecker().isStraightProject(sequence, 3);
	}
}

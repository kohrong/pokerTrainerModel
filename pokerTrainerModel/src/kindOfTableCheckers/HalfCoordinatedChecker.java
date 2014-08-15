package kindOfTableCheckers;

import java.util.ArrayList;

import pokertrainer.Card;
import table.Board;
import cardListAttributesChecker.MaximumGapChecker;
import cardListAttributesChecker.SameSuitChecker;

public class HalfCoordinatedChecker implements KindOfTableChecker{

	@Override
	public boolean check(Board board) {
		return isHalfCoordinated(board);
	}
	
	public boolean isHalfCoordinated(Board board) {
		if(new ExtremelyCoordinatedChecker().isExtremelyCoordinated(board)
				|| new CoordinatedChecker().isCoordinated(board))	return false;
		if(board.isPreFlop())	return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++)	sequence.add(board.get(i));
		
		if(new SameSuitChecker().sameSuit(sequence, 2))
			return new MaximumGapChecker().check(sequence, 4);
		else	return new MaximumGapChecker().check(sequence, 3);
	}
}

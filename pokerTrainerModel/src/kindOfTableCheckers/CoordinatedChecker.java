package kindOfTableCheckers;

import java.util.ArrayList;

import cardListAttributesChecker.CardsConnectedChecker;
import cardListAttributesChecker.SameSuitChecker;
import pokertrainer.Card;
import table.Board;

public class CoordinatedChecker implements KindOfTableChecker{

	@Override
	public boolean check(Board board) {
		return isCoordinated(board);
	}

	public boolean isCoordinated(Board board) {
		if(board.isPreFlop() || new ExtremelyCoordinatedChecker().isExtremelyCoordinated(board)) return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++) sequence.add(board.get(i));
		
		if(new SameSuitChecker().check(sequence, 3))	return true;
		return new CardsConnectedChecker().check(sequence, 3);
	}
}

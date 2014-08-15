package kindOfTableCheckers;

import java.util.ArrayList;

import cardListAttributesChecker.CardsConnectedChecker;
import cardListAttributesChecker.SameSuitChecker;
import pokertrainer.Card;
import table.Board;

public class ExtremelyCoordinatedChecker implements KindOfTableChecker{
	
	@Override
	public boolean check(Board board) {
		return isExtremelyCoordinated(board);
	}
	
	public boolean isExtremelyCoordinated(Board board) {
		if(board.isPreFlop() || board.isFlop())	return false;
		
		ArrayList<Card> sequence = new ArrayList<>();
		for(int i = 0; i < board.size(); i++) sequence.add(board.get(i));

		if(new SameSuitChecker().check(sequence, 4))	return true;
		return new CardsConnectedChecker().check(sequence, 4);
	}
}

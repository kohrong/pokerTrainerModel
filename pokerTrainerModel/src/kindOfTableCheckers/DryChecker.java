package kindOfTableCheckers;

import table.Board;

public class DryChecker implements KindOfTableChecker{

	@Override
	public boolean check(Board board) {
		return isDry(board);
	}
	
	public boolean isDry(Board board){
		if(new ExtremelyCoordinatedChecker().isExtremelyCoordinated(board) 
				|| new CoordinatedChecker().isCoordinated(board))	return false;
		return true;
	}

}

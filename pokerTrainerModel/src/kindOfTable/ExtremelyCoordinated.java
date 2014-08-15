package kindOfTable;

import table.Board;

public class ExtremelyCoordinated extends KindOfTable {
	private String id;

	public ExtremelyCoordinated(String id) {
		this.id = id;
	}

	@Override
	public boolean check(Board board) {
		return new kindOfTableCheckers.ExtremelyCoordinatedChecker().check(board);
	}

	@Override
	public String toString() {
		return id;
	}

}

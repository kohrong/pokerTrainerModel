package kindOfTable;

import table.Board;

public class HalfCoordinated extends KindOfTable {
	private String id;

	public HalfCoordinated(String id) {
		this.id = id;
	}

	@Override
	public boolean check(Board board) {
		return new kindOfTableCheckers.HalfCoordinatedChecker().check(board);
	}

	@Override
	public String toString() {
		return id;
	}
}

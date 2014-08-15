package kindOfTable;

import table.Board;

public class Coordinated extends KindOfTable {
	private String id;

	public Coordinated(String id) {
		this.id = id;
	}

	@Override
	public boolean check(Board board) {
		return new kindOfTableCheckers.CoordinatedChecker().check(board);
	}

	@Override
	public String toString() {
		return id;
	}
}

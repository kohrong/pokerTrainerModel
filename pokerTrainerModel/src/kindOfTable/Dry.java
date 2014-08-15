package kindOfTable;

import table.Board;

public class Dry extends KindOfTable {
	private String id;

	public Dry(String dry) {
		this.id = dry;
	}

	@Override
	public boolean check(Board board) {
		return new kindOfTableCheckers.DryChecker().check(board);
	}

	@Override
	public String toString() {
		return id;
	}
}

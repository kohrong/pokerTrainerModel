package kindOfTable;

import table.Board;

public abstract class KindOfTable{
	public static final KindOfTable Dry = new Dry("Dry");
	public static final KindOfTable HalfCoordinated = new HalfCoordinated("HalfCoordinated");
	public static final KindOfTable Coordinated = new Coordinated("Coordinated");
	public static final KindOfTable ExtremelyCoordinated = new ExtremelyCoordinated("ExtremelyCoordinated");

	public abstract boolean check(Board board);
}

package table;

public class Street {
	public static final Street PREFLOP = new Street("PREFLOP");
	public static final Street FLOP = new Street("FLOP");
	public static final Street TURN = new Street("TURN");
	public static final Street RIVER = new Street("RIVER");
	
	private final String id;
	
	public Street(String id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id;
	}
}

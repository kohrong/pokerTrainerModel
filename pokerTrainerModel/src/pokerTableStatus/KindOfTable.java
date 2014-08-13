package pokerTableStatus;

public class KindOfTable {
	public static final KindOfTable ExtremelyCoordinated = new KindOfTable("ExtremelyCoordinated");
	public static final KindOfTable Coordinated = new KindOfTable("Coordinated");
	public static final KindOfTable HalfCoordinated = new KindOfTable("HalfCoordinated");
	public static final KindOfTable Dry = new KindOfTable("Dry");
	
	private final String id;
	
	private KindOfTable(String id){
		this.id = id;
	}
	
	public String toString(){
		return id;
	}
}

package table;

public class TableView {
	private String pokerPlayerId;
	private PokerTable pokerTable;
	
	public TableView(String pokerPlayerId, PokerTable pokerTable) {
		super();
		this.pokerPlayerId = pokerPlayerId;
		this.pokerTable = pokerTable;
	}
	
	public Stack getStack(String name){
		for(int i=0; i < pokerTable.getPlayerList().size(); i++){
				if(pokerTable.getPlayerList().get(i).getName() == name)
					return pokerTable.getPlayerList().get(i).getStack();
		}
		return null;
	}
	
	public void setPokerPlayerId(String pokerPlayerId){
		this.pokerPlayerId = pokerPlayerId;
	}
	
	public Board getBoard(){
		return pokerTable.getBoard();
	}
	
	public Pot getPot(){
		return pokerTable.getPot();
	}
	
	public int getSB(){
		return pokerTable.getSB();
	}
	
	public int getBB(){
		return pokerTable.getBB();
	}
}

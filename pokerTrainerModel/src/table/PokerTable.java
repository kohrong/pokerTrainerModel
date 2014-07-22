package table;

import java.util.ArrayList;
import pokertrainer.Deck;

public class PokerTable {
    private ArrayList<PokerPlayer> playerList;
    private int pot;
    private int street; //ENUM
    private Board board;
    private Deck deck;
    private int SB;
    private int BB;
    
	public ArrayList<PokerPlayer> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(ArrayList<PokerPlayer> playerList) {
		this.playerList = playerList;
	}
	public int getPot() {
		return pot;
	}
	public void setPot(int pot) {
		this.pot = pot;
	}
	public int getStreet() {
		return street;
	}
	public void setStreet(int street) {
		this.street = street;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public int getSB() {
		return SB;
	}
	public void setSB(int sB) {
		SB = sB;
	}
	public int getBB() {
		return BB;
	}
	public void setBB(int bB) {
		BB = bB;
	}

    
}

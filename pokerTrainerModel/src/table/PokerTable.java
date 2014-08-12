package table;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.Deck;

public class PokerTable {
    private ArrayList<PokerPlayer> pokerPlayerList;
    private Pot pot;
    private Board board;
    private Deck deck;
    private int SB;
    private int BB;
    
	public ArrayList<PokerPlayer> getPlayerList() {
		return pokerPlayerList;
	}
	
	public void setPlayerList(ArrayList<PokerPlayer> playerList) {
		this.pokerPlayerList = playerList;
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
	
	public Pot getPot() {
		return pot;
	}
	
	public void setPot(Pot pot) {
		this.pot = pot;
	}
	
	public void setRandomCardOnBoard(){
		if(board.isPreFlop()){
			Card[] cards = new Card[3];
			for(int i = 0; i < 3; i++)	cards[i] = deck.takeRandomCard();
			board.setFlop(cards);
		}
		else if(board.isFlop())	board.setTurn(deck.takeRandomCard());
		else if(board.isTurn()) board.setRiver(deck.takeRandomCard());
	}
}

package table;

import pokertrainer.Card;

public class Board {
   private Card[] flop = new Card[3];
   private Card turn;
   private Card river;
   private int street;

    public Board(Card[] flop, Card turn, Card river) {
        this.flop = flop;
        this.turn = turn;
        this.river = river;
        street = 3;
    }

    public Board(Card[] flop, Card turn) {
        this.flop = flop;
        this.turn = turn;
        this.river = null;
        street = 2;
    }

    public Board(Card[] flop) {
        this.flop = flop;
        this.turn = null;
        this.river = null;
        street = 1;
    }

    public Board() {
		this.flop = null;
		this.turn = null;
		this.river = null;
		street = 0;
	}

	public Card[] getFlop() {
        return flop;
    }

    public Card getTurn() {
        return turn;
    }

    public Card getRiver() {
        return river;
    }
    
    public int getStreet(){
    	return street;
    }

	public boolean isRiver() {
		return street == 3;
	}

	public boolean isPreFlop() {
		return street == 0;
	}
	
	public boolean isTurn(){
		return street == 2;
	}
	
	public boolean isFlop(){
		return street == 1;
	}
}

package table;

import pokertrainer.Card;

public class Board {
   private Card[] flop;
   private Card turn;
   private Card river;
   private Street street;

    public Board(Card[] flop, Card turn, Card river) {
        this.flop = flop;
        this.turn = turn;
        this.river = river;
        street = Street.RIVER;
    }

    public Board(Card[] flop, Card turn) {
        this.flop = flop;
        this.turn = turn;
        this.river = null;
        street = Street.TURN;
    }

    public Board(Card[] flop) {
        this.flop = flop;
        this.turn = null;
        this.river = null;
        street = Street.FLOP;
    }

    public Board() {
		this.flop = new Card[3];
		this.turn = null;
		this.river = null;
		street = Street.PREFLOP;
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
    
    public Street getStreet(){
    	return street;
    }

	public boolean isRiver() {
		return street == Street.RIVER;
	}

	public boolean isPreFlop() {
		return street == Street.PREFLOP;
	}
	
	public boolean isTurn(){
		return street == Street.TURN;
	}
	
	public boolean isFlop(){
		return street == Street.FLOP;
	}

	public void setFlop(Card[] cards) {
		for(int i = 0; i < 3; i++)	this.flop[i] = cards[i];
		this.street = Street.FLOP;
	}

	public void setTurn(Card turn) {
		this.turn = turn;
		this.street = Street.TURN;
	}
	
	public void setRiver(Card river){
		this.river = river;
		this.street = Street.RIVER;
	}
}

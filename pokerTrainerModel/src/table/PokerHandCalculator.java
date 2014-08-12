package table;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.PokerHand;
import pokertrainer.TexasHand;

public class PokerHandCalculator {

	private ArrayList<PokerHand> pokerHandList = new ArrayList<PokerHand>();

	public PokerHand calculatePokerHand(TexasHand texasHand, Board board) {
		if(board.isPreFlop())	return null;
		
		ArrayList<Card> sequence = new ArrayList<Card>();
		sequence.add(texasHand.getCard0());
		sequence.add(texasHand.getCard1());
		sequence.add(board.getFlop()[0]);
		sequence.add(board.getFlop()[1]);
		sequence.add(board.getFlop()[2]);

		if(board.isFlop())
			return boardOnFlop(sequence);
		if (board.isTurn()){
			sequence.add(board.getTurn());
			boardOnTurn(sequence);
		}
		if (board.isRiver()) {
			sequence.add(board.getTurn());
			sequence.add(board.getRiver());
			boardOnRiver(sequence);
		}

		return comparePokerHands();
	}

	private PokerHand comparePokerHands() {
		PokerHand pokerHand = pokerHandList.get(0);
		for (int i = 1; i < pokerHandList.size(); i++) {
			if(pokerHand.compareTo(pokerHandList.get(i)) == 1){
				pokerHand = pokerHandList.get(i);
			}
				
		}
		return pokerHand;
	}

	private void boardOnRiver(ArrayList<Card> sequence) {
		Card[] cards = new Card[5];
		
		for (int i = 0; i < (sequence.size())-1; i++) {
			for (int j = i+1; j < sequence.size(); j++) {
				int index = 0;
				for (int k = 0; k < sequence.size(); k++) {
					if(k != i && k != j)
						cards[index++] = sequence.get(k);
				}
				pokerHandList.add(new PokerHand(cards));
			}
		}
		
	}

	private void boardOnTurn(ArrayList<Card> sequence) {
		Card[] cards = new Card[5];
		
		for (int i = 0; i < sequence.size(); i++) {
			int index = 0;
			for(int j = 0; j < sequence.size(); j++){
				if(j != i)
					cards[index++] = sequence.get(j);
			}
			pokerHandList.add(new PokerHand(cards));
		}
	}

	private PokerHand boardOnFlop(ArrayList<Card> sequence) {
		PokerHand pokerHand = new PokerHand(sequence.toArray(new Card[sequence.size()]));
		return pokerHand;
	}

}

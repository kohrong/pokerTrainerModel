package cardListAttributesChecker;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.CardSuit;

public class SameSuitChecker implements CardListAttributesChecker{

	public boolean check(ArrayList<Card> sequence, int sameSuitTarget){
		return sameSuit(sequence, sameSuitTarget);
	}
	
	public boolean sameSuit(ArrayList<Card> sequence, int sameSuitTarget) {
		int sameSuit = 0;
		
		for(int i = 0; i < CardSuit.SUITS.length; i++){
			for(int j = 0; j < sequence.size(); j++){
				if(sequence.get(j).isSameSuit(CardSuit.SUITS[i]))	sameSuit++;
			}
			if(sameSuit == sameSuitTarget)	return true;
			sameSuit = 0;
		}
		return false;
	}
}

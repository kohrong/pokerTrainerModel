package cardListAttributesChecker;

import java.util.ArrayList;

import pokertrainer.Card;

public class MaximumGapChecker implements CardListAttributesChecker{
	
	public boolean check(ArrayList<Card> sequence, int maxGap){
		return closestCardsGap(sequence, maxGap);
	}
	
	private boolean closestCardsGap(ArrayList<Card> sequence, int maxGap){
		int minGap = Integer.MAX_VALUE;
		for(int i = 0; i < sequence.size()-1; i++){
			for(int j = i+1; j < sequence.size(); j++){
				minGap = calculateMinGap(sequence.get(i), sequence.get(j), minGap);			}
		}
		return minGap <= maxGap;
	}
	
	private int calculateMinGap(Card card0, Card card1, int minGap){
		if(card0.isSameNumber(card1))	return minGap;
		if(card0.isAce()){
			if(Math.abs(card0.getNumber()-card1.getValue()) < minGap)	
				return Math.abs(card0.getNumber()-card1.getValue());
		}
		else if(Math.abs(card0.getValue()-card1.getValue()) < minGap)
				return card0.getValue()-card1.getValue();
		return minGap;
	}
}

package table;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.CardSuit;

public class BoardChecker {
	
	public boolean isStraightProject(ArrayList<Card> sequence, int projectSize){
		if((sequence.size()-projectSize) == 0)	return straightProjectWithoutHollow(sequence);
		else if((sequence.size()-projectSize) == 1)	return straightProjectWithOneHollow(sequence);
		return straightProjectWithTwoHollows(sequence);
	}

	private boolean straightProjectWithoutHollow(ArrayList<Card> sequence) {
		return isSubsequenceConnected(sequence);
	}
	
	private boolean straightProjectWithOneHollow(ArrayList<Card> sequence){
		ArrayList<Card> subsequence = new ArrayList<Card>();
		boolean isProject = false;
 		
		for(int i = 0; i < sequence.size(); i++){
			for(int j = 0; j < sequence.size(); j++){
				if(j != i)	subsequence.add(sequence.get(j));
			}
			isProject = isSubsequenceConnected(subsequence);
			if(isProject) return true;
			subsequence.clear();
		}
		return false;
	}
	
	private boolean straightProjectWithTwoHollows(ArrayList<Card> sequence) {
		ArrayList<Card> subsequence = new ArrayList<Card>();
		boolean isProject = false;
 		
		for(int i = 0; i < sequence.size()-1; i++){
			for(int j = i+1; j < sequence.size(); j++){
				for(int k=0; k < sequence.size(); k++){
					if(k != i && k != j)
						subsequence.add(sequence.get(k));
				}
				isProject = isSubsequenceConnected(subsequence);
				if(isProject) return true;
				subsequence.clear();
			}			
		}
		return false;
	}
	
	private boolean isSubsequenceConnected(ArrayList<Card> subsequence) {
		for(int i = 0; i < subsequence.size()-1; i++){
			for(int j = i+1; j < subsequence.size(); j++){
				if(!subsequence.get(i).isConnected(subsequence.get(j)))
					return false;
			}
		}
		return true;
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
	
	public boolean closestCardsGap(ArrayList<Card> sequence, int maxGap){
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

package cardListAttributesChecker;

import java.util.ArrayList;

import pokertrainer.Card;

public class CardsConnectedChecker implements CardListAttributesChecker{
	
	public boolean check(ArrayList<Card> sequence, int connectedTarget){
		return cardsConnected(sequence, connectedTarget);
	}
	
	private boolean cardsConnected(ArrayList<Card> sequence, int connectedTarget){
		if((sequence.size() - connectedTarget) == 0)	return straightProjectWithoutHollow(sequence);
		else if((sequence.size() - connectedTarget) == 1)	return straightProjectWithOneHollow(sequence);
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
}

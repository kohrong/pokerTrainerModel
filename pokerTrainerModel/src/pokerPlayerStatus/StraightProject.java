package pokerPlayerStatus;

import java.util.ArrayList;

import pokertrainer.Card;
import pokertrainer.TexasHand;
import table.Board;
import table.BoardChecker;

public class StraightProject {
	private Board board;
	private TexasHand texasHand;
	private BoardChecker boardChecker;
	
	public StraightProject(Board board, TexasHand texasHand) {
		super();
		this.board = board;
		this.texasHand = texasHand;
		boardChecker = new BoardChecker();
	}
	
	public boolean isStraightProject(){
		if(board.isRiver() || board.isPreFlop())
			return false;
		else if(boardChecker.calculatePokerHand(texasHand, board).isStraight())
			return false;
		else
			return calculateStraightProject();
	}
	
	private boolean calculateStraightProject() {
		ArrayList<Card> sequence = new ArrayList<>();
		
		sequence.add(texasHand.getCard0());
		sequence.add(texasHand.getCard1());
		sequence.add(board.getFlop()[0]);
		sequence.add(board.getFlop()[1]);
		sequence.add(board.getFlop()[2]);

		if(board.isFlop())
			return boardOnFlop(sequence);
		if (board.isTurn()){
			sequence.add(board.getTurn());
			return boardOnTurn(sequence);
		}
		return false;
	}
	
	private boolean boardOnFlop(ArrayList<Card> sequence) {
		ArrayList<Card> subsequence = new ArrayList<Card>();
		boolean isProject = false;
 		
		for(int i = 0; i < sequence.size(); i++){
			for(int j = 0; j < sequence.size(); j++){
				if(j != i)	subsequence.add(sequence.get(j));
			}
			isProject = isSubsequenceConnected(subsequence);
			if(isProject) return true;
		}
		return false;
	}
	
	private boolean boardOnTurn(ArrayList<Card> sequence) {
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

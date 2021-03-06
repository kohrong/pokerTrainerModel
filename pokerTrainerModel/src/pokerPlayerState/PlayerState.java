package pokerPlayerState;

import table.Board;
import table.PokerPlayer;

public class PlayerState {
	private PokerPlayer pokerPlayer;
	private Board board;
	
	public PlayerState(PokerPlayer pokerPlayer, Board board){
		this.pokerPlayer = pokerPlayer;
		this.board = board;
	}

	public int getBlinds(int BB, PokerPlayer pokerPlayer) {
		return pokerPlayer.getStack().getChips()/BB;
	}

	public boolean isFlushProject(Board board) {
		return new FlushProject(board, pokerPlayer.getTexasHand()).isFlushProject();
	}

	public boolean isStraightProject() {
		return new StraightProject(board, pokerPlayer.getTexasHand()).isStraightProject();
	}
}

package pokerPlayerStatus;

import table.Pot;
import table.Stack;

public class StackPotRatio {
	
	private Pot pot;
	private Stack stack;
	
	public StackPotRatio(Pot pot, Stack stack){
		this.pot = pot;
		this.stack = stack;
	}

	public float getStackPotRatio(){
		return (float) stack.getChips()/pot.getTotalPot();
	}
}

package pokerPlayerStatus;

import table.Stack;

public class BlindsNumber {

	private Stack stack;
	private int bb;
	
	public BlindsNumber(Stack stack, int bb){
		this.bb = bb;
		this.stack = stack;
	}
	
	public float getNumberOfBlinds(){
		return (float) stack.getChips()/bb;
	}
}

package pokerPlayerStatus;

import static org.junit.Assert.*;

import org.junit.Test;

import pokertrainer.Card;
import pokertrainer.TexasHand;
import pokertrainer.Card.Exception;
import pokertrainer.CardSuit;
import table.Board;

public class FlushProjectTest {

	@Test
	public void testMyPokerHandIsFlush() throws Exception {
		Board board = new Board(new Card[]{new Card(7, CardSuit.CLUB), new Card(8, CardSuit.CLUB),
				new Card(9, CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		assertFalse(new FlushProject(board, texasHand).isFlushProject());
	}
	
	@Test
	public void testIsFlushProjectOffSuited() throws Exception{
		Board board = new Board(new Card[]{new Card(7, CardSuit.CLUB), new Card(8, CardSuit.CLUB),
				new Card(9, CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.DIAMOND), new Card(4, CardSuit.CLUB));
		
		assertTrue(new FlushProject(board, texasHand).isFlushProject());
	}
	
	@Test
	public void testIsFlushProjectSuited() throws Exception{
		Board board = new Board(new Card[]{new Card(7, CardSuit.CLUB), new Card(8, CardSuit.CLUB),
				new Card(9, CardSuit.DIAMOND)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		assertTrue(new FlushProject(board, texasHand).isFlushProject());
	}

}

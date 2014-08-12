package pokerPlayerStatus;

import static org.junit.Assert.*;

import org.junit.Test;

import pokertrainer.Card;
import pokertrainer.Card.Exception;
import pokertrainer.CardSuit;
import pokertrainer.TexasHand;
import table.Board;

public class StraightProjectTest {

	@Test
	public void testIsNotStraightProject() throws Exception {
		Board board = new Board(new Card[]{new Card(7, CardSuit.CLUB), new Card(8, CardSuit.CLUB),
				new Card(9, CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		StraightProject straightProject = new StraightProject(board, texasHand);
		
		assertFalse(straightProject.isStraightProject());
	}
	
	@Test
	public void testIsStraightProject() throws Exception{
		Board board = new Board(new Card[]{new Card(7, CardSuit.CLUB), new Card(6, CardSuit.CLUB),
				new Card(10, CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		StraightProject straightProject = new StraightProject(board, texasHand);
		
		assertTrue(straightProject.isStraightProject());
	}

	@Test
	public void testIsSpecialStraightProject() throws Exception{
		Board board = new Board(new Card[]{new Card('A', CardSuit.CLUB), new Card(2, CardSuit.CLUB),
				new Card(10, CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		StraightProject straightProject = new StraightProject(board, texasHand);
		
		assertTrue(straightProject.isStraightProject());
	}
	
	@Test
	public void testIsRoyalStraightProject() throws Exception{
		Board board = new Board(new Card[]{new Card('A', CardSuit.CLUB), new Card('J', CardSuit.CLUB),
				new Card('K', CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card('Q', CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		StraightProject straightProject = new StraightProject(board, texasHand);
		
		assertTrue(straightProject.isStraightProject());
	}
	
	@Test
	public void testIsNotStraightProjectCardsRepeated() throws Exception{
		Board board = new Board(new Card[]{new Card(7, CardSuit.CLUB), new Card(7, CardSuit.CLUB),
				new Card(10, CardSuit.CLUB)});
		TexasHand texasHand = new TexasHand(new Card(3, CardSuit.CLUB), new Card(4, CardSuit.CLUB));
		
		StraightProject straightProject = new StraightProject(board, texasHand);
		
		assertFalse(straightProject.isStraightProject());
	}
}

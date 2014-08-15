package pokerTableStatus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import kindOfTableCheckers.CoordinatedChecker;
import kindOfTableCheckers.ExtremelyCoordinatedChecker;
import kindOfTableCheckers.HalfCoordinatedChecker;

import org.junit.Test;

import pokertrainer.Card;
import pokertrainer.Card.Exception;
import pokertrainer.CardSuit;
import table.Board;

public class KindOfTableCheckerTest {

	@Test
	public void testIsExtremelyCoordinatedStraight() throws Exception {
		Board board = new Board(new Card[]{new Card('J', CardSuit.CLUB), new Card(10, CardSuit.SPADE),
				new Card(8, CardSuit.CLUB)}, new Card(7, CardSuit.DIAMOND));
		
		assertTrue(new ExtremelyCoordinatedChecker().check(board));
	}

	@Test
	public void testIsExtremelyCoordinatedFlush() throws Exception{
		Board board = new Board(new Card[]{new Card('A', CardSuit.CLUB), new Card(7, CardSuit.CLUB),
				new Card(8, CardSuit.CLUB)}, new Card(2, CardSuit.CLUB));
		
		assertTrue(new ExtremelyCoordinatedChecker().check(board));
	}
	
	@Test
	public void testIsCoordinatedStraight() throws Exception{
		Board board = new Board(new Card[]{new Card('J', CardSuit.HEART), new Card(8, CardSuit.SPADE),
				new Card(7, CardSuit.CLUB)});
		
		assertTrue(new CoordinatedChecker().check(board));
	}
	
	@Test
	public void testIsCoordinatedFlush() throws Exception{
		Board board = new Board(new Card[]{new Card(4, CardSuit.SPADE), new Card(10, CardSuit.DIAMOND),
				new Card(8, CardSuit.DIAMOND)}, new Card(2, CardSuit.DIAMOND));
		
		assertTrue(new CoordinatedChecker().check(board));
	}
	
	@Test
	public void testIsNotCoordinated() throws Exception{
		Board board = new Board(new Card[]{new Card(10, CardSuit.CLUB), new Card(9, CardSuit.DIAMOND),
				new Card(2, CardSuit.HEART)});
		
		assertFalse(new CoordinatedChecker().check(board));
	}
	
	@Test
	public void testIsHalfCoordinatedNotFlushProject() throws Exception{
		Board board = new Board(new Card[]{new Card('J', CardSuit.CLUB), new Card(8, CardSuit.DIAMOND),
				new Card(5, CardSuit.HEART)});
		
		assertTrue(new HalfCoordinatedChecker().check(board));
		
		board.setFlop(new Card[]{new Card(9, CardSuit.CLUB), new Card(6, CardSuit.DIAMOND),
				new Card('K', CardSuit.HEART)});
		
		assertTrue(new HalfCoordinatedChecker().check(board));
		
		board.setFlop(new Card[]{new Card('K', CardSuit.CLUB), new Card('T', CardSuit.DIAMOND),
				new Card(6, CardSuit.HEART)});
		
		assertTrue(new HalfCoordinatedChecker().check(board));
	}
	
	@Test
	public void testIsHalfCoordinatedFlushProject() throws Exception{
		Board board = new Board(new Card[]{new Card('J', CardSuit.CLUB), new Card(7, CardSuit.DIAMOND),
				new Card(5, CardSuit.CLUB)});
		
		assertTrue(new HalfCoordinatedChecker().check(board));
		
		board.setFlop(new Card[]{new Card(10, CardSuit.HEART), new Card(6, CardSuit.DIAMOND),
				new Card('A', CardSuit.HEART)});
		
		assertTrue(new HalfCoordinatedChecker().check(board));
		
		board.setFlop(new Card[]{new Card('A', CardSuit.DIAMOND), new Card('T', CardSuit.DIAMOND),
				new Card(5, CardSuit.HEART)});
		
		assertTrue(new HalfCoordinatedChecker().check(board));
	}
}

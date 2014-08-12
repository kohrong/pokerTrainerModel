package table;

import static org.junit.Assert.*;

import org.junit.Test;

import pokertrainer.Card;
import pokertrainer.Card.Exception;
import pokertrainer.CardSuit;

public class BoardTest {

	@Test
	public void testOnFlop() throws Exception {
		Board board = new Board();
		assertTrue(board.isPreFlop());
		
		board.setFlop(new Card[]{new Card(3, CardSuit.CLUB), new Card(5, CardSuit.CLUB), new Card(6, CardSuit.DIAMOND)});
		
		assertTrue(board.isFlop());
		assertNotNull(board.getFlop());
	}
	
	@Test
	public void testOnTurn() throws Exception{
		Board board = new Board(new Card[]{new Card(3, CardSuit.CLUB), new Card(5, CardSuit.CLUB), new Card(6, CardSuit.DIAMOND)},
				new Card(8, CardSuit.HEART));
		
		assertTrue(board.isTurn());
		assertNotNull(board.getFlop());
		assertNotNull(board.getTurn());
	}

	@Test
	public void testOnRiver() throws Exception{
		Board board = new Board(new Card[]{new Card(3, CardSuit.CLUB), new Card(5, CardSuit.CLUB), new Card(6, CardSuit.DIAMOND)},
				new Card(8, CardSuit.HEART), new Card(2, CardSuit.SPADE));
		
		assertTrue(board.isRiver());
		assertNotNull(board.getFlop());
		assertNotNull(board.getTurn());
		assertNotNull(board.getRiver());
	}
}

package table;

import static org.junit.Assert.*;

import org.junit.Test;

import pokertrainer.Card.Exception;
import pokertrainer.Deck;

public class PokerTableTest {

	@Test
	public void testPutFlop() throws Exception {
		PokerTable pokerTable = new PokerTable();
		Board board = new Board();
		Deck deck = new Deck();
		
		pokerTable.setDeck(deck);
		pokerTable.setBoard(board);
		
		assertTrue(pokerTable.getBoard().isPreFlop());
		
		pokerTable.setRandomCardOnBoard();
		
		assertTrue(pokerTable.getBoard().isFlop());
		assertTrue(pokerTable.getDeck().getCardList().size() == 49);
	}
	
	public void testPutTurn() throws Exception{
		PokerTable pokerTable = new PokerTable();
		Board board = new Board();
		Deck deck = new Deck();
		
		pokerTable.setDeck(deck);
		pokerTable.setBoard(board);
		
		for(int i = 0; i < 2; i++)	pokerTable.setRandomCardOnBoard();
		
		assertTrue(pokerTable.getBoard().isTurn());
		assertTrue(pokerTable.getDeck().getCardList().size() == 48);
	}
	
	public void testPutRiver() throws Exception{
		PokerTable pokerTable = new PokerTable();
		Board board = new Board();
		Deck deck = new Deck();
		
		pokerTable.setDeck(deck);
		pokerTable.setBoard(board);
		
		for(int i = 0; i < 3; i++)	pokerTable.setRandomCardOnBoard();
		
		assertTrue(pokerTable.getBoard().isRiver());
		assertTrue(pokerTable.getDeck().getCardList().size() == 47);
	}
	
	public void testTryingToPutOneMore() throws Exception{
		PokerTable pokerTable = new PokerTable();
		Board board = new Board();
		Deck deck = new Deck();
		
		pokerTable.setDeck(deck);
		pokerTable.setBoard(board);
		
		for(int i = 0; i < 4; i++)	pokerTable.setRandomCardOnBoard();
				
		assertTrue(pokerTable.getBoard().isRiver());
		assertTrue(pokerTable.getDeck().getCardList().size() == 47);
	}

}

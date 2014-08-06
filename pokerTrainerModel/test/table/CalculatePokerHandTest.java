package table;

import static org.junit.Assert.*;

import org.junit.Test;

import categoryCheckers.StraightChecker;
import pokertrainer.Card;
import pokertrainer.Card.Exception;
import pokertrainer.CardSuit;
import pokertrainer.PokerHand;
import pokertrainer.TexasHand;
import table.Board;
import table.BoardChecker;
import table.PokerPlayer;
import table.Stack;
import table.TablePosition;

public class CalculatePokerHandTest {
	PokerTable pokerTable = new PokerTable();

	@Test
	public void testPreFlop() throws Exception {	
		Board board = new Board();
		pokerTable.setBoard(board);
		
		PokerPlayer pokerPlayer = new PokerPlayer("Josue", new Stack(1000), TablePosition.BB, 
				new TexasHand(new Card(7, CardSuit.CLUB), new Card(8, CardSuit.DIAMOND)), new TableView("Josue", pokerTable));
		
		BoardChecker boardChecker = new BoardChecker();
		PokerHand pokerHand = boardChecker.calculatePokerHand(pokerPlayer.getTexasHand(), board);
		
		assertTrue(pokerHand == null);
	}
	
	@Test
	public void testOnFlop() throws Exception {
		Board board = new Board(new Card[]{new Card(4, CardSuit.SPADE), new Card(5, CardSuit.DIAMOND), 
				new Card(6, CardSuit.CLUB)});
		pokerTable.setBoard(board);
		
		PokerPlayer pokerPlayer = new PokerPlayer("Josue", new Stack(1000), TablePosition.BB, 
				new TexasHand(new Card(7, CardSuit.CLUB), new Card(8, CardSuit.DIAMOND)),
				new TableView("Josue", pokerTable));
		
		BoardChecker boardChecker = new BoardChecker();
		PokerHand pokerHand = boardChecker.calculatePokerHand(pokerPlayer.getTexasHand(), board);
		
		pokerPlayer.setPokerHand(pokerHand);
		
		StraightChecker straightChecker = new StraightChecker();
		assertTrue(straightChecker.check(pokerPlayer.getPokerHand()));
	}
	
	@Test
	public void testOnTurn() throws Exception{
		Board board = new Board(new Card[]{new Card(4, CardSuit.SPADE), new Card(5, CardSuit.DIAMOND), 
				new Card(6, CardSuit.CLUB)}, new Card(9, CardSuit.HEART));
		pokerTable.setBoard(board);
		
		PokerPlayer pokerPlayer = new PokerPlayer("Josue", new Stack(1000), TablePosition.BB, 
				new TexasHand(new Card(7, CardSuit.CLUB), new Card(8, CardSuit.DIAMOND)), 
				new TableView("Josue", pokerTable));
		
		
		
		BoardChecker boardChecker = new BoardChecker();
		PokerHand pokerHand = boardChecker.calculatePokerHand(pokerPlayer.getTexasHand(), board);
		
		pokerPlayer.setPokerHand(pokerHand);
		
		StraightChecker straightChecker = new StraightChecker();
		assertTrue(straightChecker.check(pokerPlayer.getPokerHand()));
		
		assertTrue(pokerHand.getCard(0).getValue() == 9);
	}

	@Test
	public void testOnRiver() throws Exception{
		Board board = new Board(new Card[]{new Card(4, CardSuit.SPADE), new Card(5, CardSuit.DIAMOND), 
				new Card(6, CardSuit.CLUB)}, new Card(9, CardSuit.HEART), new Card(10, CardSuit.CLUB));
		pokerTable.setBoard(board);
		
		PokerPlayer pokerPlayer = new PokerPlayer("Josue", new Stack(1000), TablePosition.BB, 
				new TexasHand(new Card(7, CardSuit.CLUB), new Card(8, CardSuit.DIAMOND)),
				new TableView("Josue", pokerTable));
		
		
		
		BoardChecker boardChecker = new BoardChecker();
		PokerHand pokerHand = boardChecker.calculatePokerHand(pokerPlayer.getTexasHand(), board);
		
		pokerPlayer.setPokerHand(pokerHand);
		
		StraightChecker straightChecker = new StraightChecker();
		
		assertTrue(straightChecker.check(pokerPlayer.getPokerHand()));
		assertTrue(pokerPlayer.getPokerHand().getCard(0).getValue() == 10);
	}
}

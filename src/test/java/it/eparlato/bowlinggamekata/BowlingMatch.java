package it.eparlato.bowlinggamekata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingMatch {
	Game game;
	
	@Before
	public void setup() {
		game = new Game();
	}
	
	@Test
	public void singleThrow() throws Exception {
		game.rolls(1);
		
		assertEquals(1, game.score());
	}
	
	@Test
	public void twoThrowsNoBonus() throws Exception {
		game.rolls(2);
		game.rolls(6);
		
		assertEquals(8, game.score());
	}
	
	@Test
	public void fewThrowsNoBonuses() throws Exception {
		
		game.rolls(3);
		game.rolls(6);
		game.rolls(7);
		game.rolls(1);
		game.rolls(2);
		game.rolls(5);
		
		assertEquals(24, game.score());
	}
	
	@Test
	public void fewThrowsWithSpare() throws Exception {
		
		game.rolls(4);
		game.rolls(6);
		game.rolls(5);
		game.rolls(3);
		
		assertEquals(23, game.score());
	}
	
	@Test
	public void fewThrowsWithStrike() throws Exception {
		game.rolls(10);
		game.rolls(5);
		game.rolls(3);
		
		assertEquals(26, game.score());
	}
	
	@Test
	public void perfectGame() throws Exception {
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		game.rolls(10);
		
		assertEquals(300, game.score());
	}
}

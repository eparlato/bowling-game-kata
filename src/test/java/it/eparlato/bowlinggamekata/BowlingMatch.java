package it.eparlato.bowlinggamekata;

import static org.junit.Assert.assertEquals;

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
}

package it.eparlato.bowlinggamekata;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTester {
	
	@Test
	public void totalScoreUsingNoBonusFrames() throws Exception {
		Game game = new Game();
		
		game.rolls(4);
		game.rolls(2);
		game.rolls(5);
		game.rolls(3);
		
		Frame firstFrame = game.getFrame(1);
		Frame secondFrame = game.getFrame(2);
		
		assertEquals(14, firstFrame.getScore() + secondFrame.getScore());
	}
}

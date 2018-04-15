package it.eparlato.bowlinggamekata;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class FrameTester {
	
	@Test
	public void totalScoreUsingNoBonusFrames() throws Exception {
		Game game = new Game();
		
		game.rolls(4);
		game.rolls(2);
		game.rolls(5);
		game.rolls(3);
		
		List<Frame> frames = game.getFrames();
		assertEquals(14, frames.get(0).getScore() + frames.get(1).getScore());
	}
	
}

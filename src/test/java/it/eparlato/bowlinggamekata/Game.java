package it.eparlato.bowlinggamekata;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int score = 0;
	private int[] rolls = new int[21];
	private int rollsIndex = 0;

	public void rolls(int pinsKnockedDown) {
		rolls[rollsIndex++] = pinsKnockedDown;
	}

	public int score() {

		for (Frame frame : getFrames()) {
			score += frame.getScore();
		}

		return score;
	}

	public List<Frame> getFrames() {
		List<Frame> frames = new ArrayList<Frame>();

		int rollIndex = 0;

		while (rollIndex < rolls.length) {
			if (rollIndex == 18) {
				// last frame
				frames.add(
						new NoBonusFrame(new int[] { rolls[rollIndex], rolls[rollIndex + 1], rolls[rollIndex + 2] }));
				break;
			} else {
				frames.add(new NoBonusFrame(new int[] { rolls[rollIndex], rolls[rollIndex + 1] }));
				rollIndex += 2;
			}
		}

		return frames;
	}

}

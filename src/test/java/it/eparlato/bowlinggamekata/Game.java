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
						new NoBonusFrame(new int[] { currentFrameFirstThrow(rollIndex), currentFrameSecondThrow(rollIndex), lastFrameLastThrow(rollIndex) }));
				break;
			} else if (isSpare(rollIndex)) {
				frames.add(new SpareFrame(nextFrameFirstThrow(rollIndex)));
				rollIndex += 2;
			} else if(rolls[rollIndex] == 10) {
				// strike
				frames.add(new StrikeFrame(rolls[rollIndex + 1], rolls[rollIndex + 2]));
				rollIndex += 1;
			} else {
				frames.add(new NoBonusFrame(new int[] { currentFrameFirstThrow(rollIndex), currentFrameSecondThrow(rollIndex) }));
				rollIndex += 2;
			}
		}

		return frames;
	}
	
	private int currentFrameFirstThrow(int rollIndex) {
		return rolls[rollIndex];
	}
	
	private int currentFrameSecondThrow(int rollIndex) {
		return rolls[rollIndex + 1];
	}
	
	private int lastFrameLastThrow(int rollIndex) {
		return rolls[rollIndex + 2];
	}
	
	private int nextFrameFirstThrow(int rollIndex) {
		return rolls[rollIndex + 2];
	}
	
	private boolean isSpare(int rollIndex) {
		return currentFrameFirstThrow(rollIndex) + currentFrameSecondThrow(rollIndex) == 10;
	}
	
}

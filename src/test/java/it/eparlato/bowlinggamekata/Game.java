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
			if (frames.size() == 9) {
				// last frame
				if (isStrike(rollIndex) || isSpare(rollIndex)) {
					frames.add(new LastFrame(new int [] {rolls[rollIndex], rolls[rollIndex + 1], rolls[rollIndex + 2]}));
				} else {
					frames.add(new LastFrame(new int [] {rolls[rollIndex], rolls[rollIndex + 1]}));
				}
				
				break;
			} else if (isSpare(rollIndex)) {
				frames.add(new SpareFrame(nextFrameFirstThrow(rollIndex)));
				rollIndex += 2;
			} else if(isStrike(rollIndex)) {
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
	
	private int nextFrameFirstThrow(int rollIndex) {
		return rolls[rollIndex + 2];
	}
	
	private boolean isSpare(int rollIndex) {
		return currentFrameFirstThrow(rollIndex) + currentFrameSecondThrow(rollIndex) == 10;
	}
	
	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}
	
}

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
		Frame frame;
		
		while (rollIndex < rolls.length) {
			if (frames.size() == 9) {
				if (isStrike(rollIndex) || isSpare(rollIndex)) {
					frame = new Frame(new int [] {currentThrow(rollIndex), nextThrow(rollIndex), nextSecondThrow(rollIndex)});
				} else {
					frame = new Frame(new int [] {currentThrow(rollIndex), nextThrow(rollIndex)});
				}
				frames.add(frame);
				
				break;
			} else if (isSpare(rollIndex)) {
				frame = new BonusFrame(new int[] {nextSecondThrow(rollIndex)});
				rollIndex += 2;
			} else if (isStrike(rollIndex)) {
				frame = new BonusFrame(new int[] { nextThrow(rollIndex), nextSecondThrow(rollIndex)});
				rollIndex += 1;
			} else {
				frame = new Frame(new int[] { currentThrow(rollIndex), nextThrow(rollIndex) });
				rollIndex += 2;
			}
			
			frames.add(frame);
		}
		

		return frames;
	}
	
	private int currentThrow(int rollIndex) {
		return rolls[rollIndex];
	}
	
	private int nextThrow(int rollIndex) {
		return rolls[rollIndex + 1];
	}
	
	private int nextSecondThrow(int rollIndex) {
		return rolls[rollIndex + 2];
	}
	
	private boolean isSpare(int rollIndex) {
		return currentThrow(rollIndex) + nextThrow(rollIndex) == 10;
	}
	
	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}
	
}

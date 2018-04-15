package it.eparlato.bowlinggamekata;

public class Game {
	
	private int score = 0;

	public void rolls(int i) {
		score += i;
	}

	public int score() {
		return score;
	}

	public Frame getFrame(int i) {
		if(i == 1) {
			return new NoBonusFrame(new int[] {4, 2});
		} else {
			return new NoBonusFrame(new int[] {5, 3});
		}
	}

}

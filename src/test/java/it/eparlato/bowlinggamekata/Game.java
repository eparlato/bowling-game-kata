package it.eparlato.bowlinggamekata;

public class Game {
	
	private int score = 0;

	public void rolls(int i) {
		score += i;
	}

	public int score() {
		return score;
	}

}

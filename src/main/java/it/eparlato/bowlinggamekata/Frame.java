package it.eparlato.bowlinggamekata;

public class Frame {

	private int[] rolls;
	
	public Frame(int[] rolls) {
		this.rolls = rolls;
	}
	
	protected int getScore() {
		int score = 0;
		
		for (int roll : rolls) {
			score += roll;
		}
		
		return score;
	}
}

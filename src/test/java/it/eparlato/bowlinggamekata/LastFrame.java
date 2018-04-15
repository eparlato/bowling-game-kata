package it.eparlato.bowlinggamekata;

public class LastFrame implements Frame {

	private int[] rolls;

	public LastFrame(int[] rolls) {
		this.rolls = rolls;
	}

	public int getScore() {
		int score = 0;
		
		for (int roll : this.rolls) {
			score += roll;
		}
		
		return score;
	}

}

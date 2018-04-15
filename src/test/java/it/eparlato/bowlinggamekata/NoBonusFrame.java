package it.eparlato.bowlinggamekata;

public class NoBonusFrame implements Frame {

	private int[] rolls;

	public NoBonusFrame(int[] rolls) {
		this.rolls = rolls;
	}

	public int getScore() {
		return rolls[0] + rolls[1];
	}

}

package it.eparlato.bowlinggamekata;

public class BonusFrame extends Frame {

	public BonusFrame(int[] rolls) {
		super(rolls);
	}

	public int getScore() {
		return 10 + super.getScore();
	}

}

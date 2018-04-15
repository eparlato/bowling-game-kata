package it.eparlato.bowlinggamekata;

public class StrikeFrame implements Frame {

	private int nextFrameFirstThrow;
	private int nextFrameSecondThrow;

	public StrikeFrame(int nextFrameFirstThrow, int nextFrameSecondThrow) {
		this.nextFrameFirstThrow = nextFrameFirstThrow;
		this.nextFrameSecondThrow = nextFrameSecondThrow;
	}

	public int getScore() {
		return 10 + nextFrameFirstThrow + nextFrameSecondThrow;
	}

}

package it.eparlato.bowlinggamekata;

public class SpareFrame implements Frame {

	private int nextFrameFirstThrow;

	public SpareFrame(int nextFrameFirstThrow) {
		this.nextFrameFirstThrow = nextFrameFirstThrow;
	}

	public int getScore() {
		return 10 + this.nextFrameFirstThrow;
	}

}

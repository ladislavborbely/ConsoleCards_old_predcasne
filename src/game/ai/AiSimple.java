package game.ai;

import game.Hand;

public class AiSimple {
	private Hand hand;

	public AiSimple(Hand hand) {
		this.hand = hand;
	}

	public boolean wantNextCard() {
		if (hand.getValue() < 14) {
			return true;
		} else {
			return false;
		}
	}

	public int getHandValue() {
		return hand.getValue();
	}

}

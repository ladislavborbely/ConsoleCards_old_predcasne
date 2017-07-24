package game.ai;

import game.Hand;

/**
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 *
 */


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

package game.ai;

import game.Hand;

/**
 * Simple computer player if hand value < 15 ask for another card
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
		if (hand.getValue() < 15) {
			return true;
		} else {
			return false;
		}
	}

	public int getHandValue() {
		return hand.getValue();
	}

}

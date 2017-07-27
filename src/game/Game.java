package game;

import java.util.Scanner;

import game.ai.AiSimple;

/**
 * Simple game logic, for now just a test of other classes!
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 */

public class Game {

	private Scanner sc = new Scanner(System.in);
	private Hand playerHandHuman = new Hand("Laco");
	private Hand playerHandPc = new Hand("Ai simple");
	private Deck deck = new Deck();
	private int round = 1;
	private boolean end = false;

	/**
	 * Run the game
	 */
	public void run() {
		AiSimple ai = new AiSimple(playerHandPc);
		deck.generate();
		deck.shuffle();

		dealFirstRound();
		printEndOfTurn();

		while (!end) {//len skuska ci funguju veci
			doesPlayerWantAcard(playerChoice(), playerHandHuman);
			doesPlayerWantAcard(ai.wantNextCard(), playerHandPc);
			printEndOfTurn();

			if (playerHandHuman.getValue() > 21 && playerHandPc.getValue() > 21) { // both have more than 21 -- needs fix
				System.out.println(playerHandHuman.getValue() >= 22 ? "Human player looses" : "AI player looses");
				end = true;
				break;
			}
			if (playerHandHuman.getValue() > 21 || playerHandPc.getValue() > 21) { // some has more than 21
				System.out.println(playerHandHuman.getValue() >= 22 ? "Human player looses" : "AI player looses");
				end = true;
				break;
			}
			if ((playerHandHuman.getLock() && playerHandPc.getLock()) && (playerHandHuman.getValue() == playerHandPc.getValue())) {//no one wants a card and values are equal
				System.out.println("Draw!");
				end = true;
				break;
			}
			if (playerHandHuman.getLock() && playerHandPc.getLock()) { //players do not want more cards
				System.out.println("Hands down, lets compare > " + playerHandHuman.getHandOwnerName() + " has: " + playerHandHuman.getValue() + ", " + playerHandPc.getHandOwnerName() + " has: "
						+ playerHandPc.getValue());
				end = true;
				break;
			}
		}

		System.out.println("End of game.");
	}

	/**
	 * Player choice
	 * 
	 * @return true for more cards, false for no more cards
	 */

	private boolean playerChoice() {
		System.out.println("Press \"n\" for next card, any other key to stop ...");
		if (sc.nextLine().equals("n")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * If a player wants a card then its added to the "his" hand.
	 * 
	 * @param nextCard
	 *            true for next card, false for stop +lock the hand
	 * @param hand
	 *            in case of nextCard = true add a card to this hand
	 */
	private void doesPlayerWantAcard(boolean nextCard, Hand hand) {
		if (nextCard) { //next card = true
			System.out.println(hand.getHandOwnerName() + ": More please.");
			giveCardTo(hand);
		} else { // no next card
			System.out.println(hand.getHandOwnerName() + ": Enough.");
			hand.setLock(true);
		}
	}

	/**
	 * Print end of turn line, visual feature.
	 */
	private void printEndOfTurn() {
		System.out.println("══════════════════════════ End of round " + round++ + "══════════════════════════");
	}

	/**
	 * Give a card to each player
	 */
	private void dealFirstRound() {
		giveCardTo(playerHandHuman);
		giveCardTo(playerHandPc);
	}

	/**
	 * Give a card to hand and show the cards in hand + values
	 * 
	 * @param hand
	 */
	private void giveCardTo(Hand hand) {
		hand.addCard(deck.getNextCard());
		hand.showHandAdvanced();
		System.out.println("Player: " + hand.getHandOwnerName() + " Total:" + hand.getValue());
		System.out.println();
	}
}
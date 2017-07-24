package game;

import java.util.Scanner;

import game.ai.AiSimple;


/**
 * 
 * Simple game logic, for now just a test of other classes!
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 *
 */

public class Game {

	private Scanner sc = new Scanner(System.in);
	private Hand playerHandHuman = new Hand("Laco");
	private Hand playerHandPc = new Hand("Ai simple");
	private Deck deck = new Deck();

	public void run() {
		AiSimple ai = new AiSimple(playerHandPc);
		int round = 1;

		deck.generate();
		deck.shuffle();
		dealFirstRound();

		System.out.println("══════════════════════════ End of round " + round++ + "══════════════════════════");

		while (playerHandHuman.getValue() < 22 && playerHandPc.getValue() < 22) {//len skuska ci funguju veci

			System.out.println("\"n\" for next card else for stop ...");
			if (sc.nextLine().equals("n")) {
				System.out.println(playerHandHuman.getHandOwnerName() + ": More please.");
				giveCardTo(playerHandHuman);
				System.out.println();
			} else {
				System.out.println(playerHandHuman.getHandOwnerName() + ": Enough.");
				System.out.println();
			}

			System.out.println();
			System.out.println("Ai turn...");
			if (ai.wantNextCard()){
				System.out.println(playerHandPc.getHandOwnerName() + ": More please.");
				giveCardTo(playerHandPc);
				System.out.println();
			} else {
				System.out.println(playerHandPc.getHandOwnerName() + ": Enough.");
				System.out.println();
			}

			System.out.println("══════════════════════════ End of round " + round++ + "══════════════════════════");
		}
		System.out.println("More than 22!");
	}

	private void dealFirstRound() {
		giveCardTo(playerHandHuman);
		giveCardTo(playerHandPc);
	}

	private void giveCardTo(Hand playerHand) {
		playerHand.addCard(deck.getNextCard());
		playerHand.showHandAdvanced();
		System.out.println("Player: " + playerHand.getHandOwnerName() + " Total:" + playerHand.getValue());
	}
}
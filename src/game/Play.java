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

public class Play {
	private static Hand playerHandHuman = new Hand("Laco");
	private static Hand playerHandPc = new Hand("Ai simple");
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Deck deck = new Deck();
		AiSimple ai = new AiSimple(playerHandPc);
		int round = 1;

		deck.generate();
		deck.shuffle();

		//prve rozdanie
		playerHandPc.addCard(deck.getNextCard());
		playerHandHuman.addCard(deck.getNextCard());

		playerHandPc.showHandSimple();
		playerHandHuman.showHandSimple();

		while (true) {//len skuska ci funguju veci

			System.out.println("\"n\" for next card else for stop ...");
			if (sc.nextLine().equals("n")) {
				playerHandHuman.addCard(deck.getNextCard());
				System.out.println(playerHandHuman.getHandOwner() + ": More please.");
				System.out.println();
			} else {
				System.out.println(playerHandHuman.getHandOwner() + ": Enough.");
				System.out.println();
			}
			playerHandHuman.showHandSimple();
			playerHandHuman.showHandAdvanced();

			if (ai.wantNextCard()){
				playerHandPc.addCard(deck.getNextCard());
				System.out.println(playerHandPc.getHandOwner() + ": More please.");
				System.out.println();
			} else {
				System.out.println(playerHandHuman.getHandOwner() + ": Enough.");
				System.out.println();
			}
			playerHandPc.showHandSimple();
			playerHandPc.showHandAdvanced();

			System.out.println("---End of round " + round++ + "-----------------------------------------------------");
		}
	}
}


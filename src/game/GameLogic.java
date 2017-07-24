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

public class GameLogic {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Hand playerHandHuman = new Hand("Laco");
		Hand playerHandPc = new Hand("Ai simple");
		Deck deck = new Deck();
		AiSimple ai = new AiSimple(playerHandPc);
		int round = 1;

		deck.generate();
		deck.shuffle();

		//prve rozdanie
		playerHandPc.addCard(deck.getNextCard());
		playerHandHuman.addCard(deck.getNextCard());

		playerHandHuman.showHandAdvanced();
		playerHandPc.showHandAdvanced();

		System.out.println("══════════════════════════ End of round " + round++ + "══════════════════════════");


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
			playerHandHuman.showHandAdvanced();

			System.out.println("");
			System.out.println("Ai turn...");
			if (ai.wantNextCard()){
				playerHandPc.addCard(deck.getNextCard());
				System.out.println(playerHandPc.getHandOwner() + ": More please.");
				System.out.println();
			} else {
				System.out.println(playerHandPc.getHandOwner() + ": Enough.");
				System.out.println();
			}
			playerHandPc.showHandAdvanced();

			System.out.println("══════════════════════════ End of round " + round++ + "══════════════════════════");
		}
	}
}
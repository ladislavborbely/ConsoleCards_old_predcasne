package game;

import java.util.ArrayList;

/**
 * 
 * @author Ladislav Borbely
 * @version 0.1 (24. 7. 2017)
 *
 *          Class that shows graphical representation cards of players hand in
 *          console.
 */

public class Table {

	private String[] printHalfCardLeft(char color, String value) {
		String[] half = new String[9];
		if (value.length() == 1) {
			value += " "; // other than 10
		}
		half[0] = "┏━━━━━━━"; //8
		half[1] = "┃ " + color + "        ";
		half[2] = "┃ " + value + "  ";
		half[3] = "┃     ";
		half[4] = "┃     ";
		half[5] = "┃     ";
		half[6] = "┃     ";
		half[7] = "┃     ";
		half[8] = "┗━━━━━━━";
		return half;
	}

	private String[] printHalfCardright(char color, String value) {
		String[] half = new String[9];
		if (value.length() == 1) {
			value += " "; // other than 10
		}
		half[0] = "━━━━━━━┓"; //8
		half[1] = "                ┃";
		half[2] = "      ┃";
		half[3] = "      ┃";
		half[4] = "      ┃";
		half[5] = "      ┃";
		half[6] = "    " + color + " ┃";
		half[7] = "  " + value + "  ┃";
		half[8] = "━━━━━━━┛";
		return half;
	}

	/**
	 * Merge two half card - two arrays of String
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	private String[] mergeCards(String[] first, String[] second) {
		for (int i = 0; i < first.length; i++) {
			first[i] += second[i];
		}
		return first;
	}


	public void printHandRepresentation(ArrayList<Card> hand) {
		String[] allCards = { "", "", "", "", "", "", "", "", "" };
		for(Card card: hand){
			allCards = mergeCards(allCards, printHalfCardLeft(card.getSymbolOfColor(), card.getSymbol()));
		}
		allCards = mergeCards(allCards, printHalfCardright(hand.get(hand.size() - 1).getSymbolOfColor(), hand.get(hand.size() - 1).getSymbol()));

		for (String row : allCards) {
			System.out.println(row);
		}
	}

}


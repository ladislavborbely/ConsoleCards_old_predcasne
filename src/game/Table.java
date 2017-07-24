package game;

import java.util.ArrayList;

/**
 * Class that shows graphical representation cards of players hand in
 * 
 * 
 * @author Ladislav Borbely
 * @version 0.1 (24. 7. 2017) console.
 */

public class Table {

	private String[] printHalfCardLeft(char color, String value) {
		String[] half = new String[9];
		if (value.length() == 1) {
			value += " "; // other than 10
		}
		half[0] = "═════"; //8
		half[1] = " " + value + "  ";
		half[2] = " " + color + "   ";
		half[3] = "     ";
		half[4] = "     ";
		half[5] = "     ";
		half[6] = "     ";
		half[7] = "     ";
		half[8] = "═════";
		return half;

	}

	private String[] printHalfCardright(char color, String value) {
		String[] half = new String[9];
		if (value.length() == 1) {
			value += " "; // other than 10
		}
		half[0] = "═════╗"; //8
		half[1] = "     ║";
		half[2] = "     ║";
		half[3] = "     ║";
		half[4] = "     ║";
		half[5] = "     ║";
		half[6] = "  " + value + " ║";
		half[7] = "  " + color + "  ║";
		half[8] = "═════╝";
		return half;
	}

	private String[] printMidCard() {
		String[] half = new String[9];

		half[0] = "╦"; //8
		half[1] = "║";
		half[2] = "║";
		half[3] = "║";
		half[4] = "║";
		half[5] = "║";
		half[6] = "║";
		half[7] = "║";
		half[8] = "╩";
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
		String allCards[] = { "╔", "║", "║", "║", "║", "║", "║", "║", "╚" };
		for(Card card: hand){
			if (allCards[0].length() == 1) {
				allCards = mergeCards(allCards, printHalfCardLeft(card.getSymbolOfColor(), card.getSymbol()));
			} else {
				mergeCards(allCards, printMidCard());
				mergeCards(allCards, printHalfCardLeft(card.getSymbolOfColor(), card.getSymbol()));
			}
		}
		allCards = mergeCards(allCards, printHalfCardright(hand.get(hand.size() - 1).getSymbolOfColor(), hand.get(hand.size() - 1).getSymbol()));

		for (String row : allCards) {
			System.out.println(row);
		}
	}
}


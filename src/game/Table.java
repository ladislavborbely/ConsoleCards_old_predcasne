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

	private String[] printHalfCard(char color, String value) {
		String[] half = new String[10];
		if (value.length() == 1) {
			value += " "; // other than 10
		}
		half[0] = "┏━━━━━"; //6
		half[1] = "┃";
		half[2] = "┃  " + color + "  ";
		half[3] = "┃ " + value + "  ";
		half[4] = "┃    ";
		half[5] = "┃    ";
		half[6] = "┃    ";
		half[7] = "┃    ";
		half[8] = "┃    ";
		half[9] = "┗━━━━━";
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
		for(Card card: hand){
			//hand
		}
	}

}


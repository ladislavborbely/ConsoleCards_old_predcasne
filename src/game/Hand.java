package game;

import java.util.ArrayList;

/**
 * 
 * @author Ladislav Borbely
 * @version 0.1
 *
 */
public class Hand {
	private int value = 0;
	private ArrayList<Card> handCards = new ArrayList<>();
	private String name;

	public Hand(String name) {
		this.name = name;
	}

	public void addCard(Card card) {
		handCards.add(card);
		value += card.getValue();
	}

	public int getValue() {
		return value;
	}

	public void showHandSimple() {
		System.out.println("Hrac:" + name);
		for (Card card : handCards) {
			System.out.println(card.toString());
		}
		System.out.println("Value: " + value);
		System.out.println();
	}

	public String getHandOwner() {
		return name;
	}

	public void discardCards() {
		handCards.clear();
		System.out.println(name + " has empty hand value: " + value);
	}

}

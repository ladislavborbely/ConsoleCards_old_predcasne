package game;

import java.util.ArrayList;
import java.util.Random;

import game.enums.CardColor;
import game.enums.CardType;

/**
 * Generate and shuffle the deck, then remove card by card (given to players)
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 *
 */

public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();
	private Random rand = new Random();

	public void generate() {
		deck.clear();
		for (CardColor color : CardColor.values()) { //of each color
			for (CardType nameValue : CardType.values()) { //of each type
				deck.add(new Card(nameValue, color));
			}
		}
	}

	public void shuffle() { //this simulates real life shuffle
		ArrayList<Card> shuffledDeck = new ArrayList<>();
		int randNumber;
		while (deck.size() > 0) {
			randNumber = rand.nextInt(deck.size());
			shuffledDeck.add(deck.get(randNumber));
			deck.remove(randNumber);
		}
		deck = shuffledDeck;
	}

	public ArrayList<Card> getShuffledDeck() {
		shuffle();
		return deck;
	}

	public Card getNextCard(){
		Card nextCard;
		nextCard = deck.get(0);
		deck.remove(0);
		return nextCard;
	}
}

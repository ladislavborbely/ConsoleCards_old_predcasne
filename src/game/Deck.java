package game;

import java.util.ArrayList;
import java.util.Random;

import game.enums.CardColor;
import game.enums.CardType;

/**
 * 
 * @author Ladislav Borbely
 * @version 0.1
 * @since 23. 7. 2017
 *
 */
public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();
	private ArrayList<Card> shuffledDeck = new ArrayList<>();
	private Random rand = new Random();

	public void generate() {
		deck.clear();
		for (CardColor color : CardColor.values()) { //z kazdej farby
			for (CardType nameValue : CardType.values()) { //kazdy druh
				deck.add(new Card(nameValue, color));
			}
		}
	}

	public void shuffle() { //mohla byt random karta pri dopyte ale takto by to bolo v reali :)
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

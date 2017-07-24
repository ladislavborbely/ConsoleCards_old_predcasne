package game;

import game.enums.CardColor;
import game.enums.CardType;

/**
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 *
 */

public class Card {
	private String name; //  7,8,9,10,J,Q,K,A
	private CardColor color; // srdce ♥,pika ♠,kriz ♣,karo ♦
	private char symbolOfColor;
	private byte value; //hodnota karty

	public Card(CardType nameValue, CardColor color) {
		this.name = nameValue.getName();
		this.color = color;
		this.symbolOfColor = color.getSymbol();
		this.value = nameValue.getValue();
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color.toString();
	}

	public char getSymbol() {
		return symbolOfColor;
	}

	public byte getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Karta name:" + name + " color:" + color + " symbol" + symbolOfColor + " value:" + value;
	}



}

package game.enums;

/**
 * Card color (and symbol)
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 *
 */

public enum CardColor {
	//srdce ♥,pika ♠,kriz ♣,karo
	SRDCE('♥'), PIKA('♠'), KRIZ('♣'), KARO('♦');

	private char symbol;

	private CardColor(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

}
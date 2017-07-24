package game.enums;

/**
 * Card properties (name, symbol, value)
 * 
 * @author Ladislav Borbely
 * @version 0.1 (23. 7. 2017)
 *
 */


public enum CardType {
	// ine pravidla = staci zmenit
	SEDEM("7", (byte) 7), OSEM("8", (byte) 8), DEVAT("9", (byte) 9), DESAT("10", (byte) 10), JACK("J", (byte) 1), QUEEN("Q", (byte) 1), KING("K", (byte) 1), ACE("A", (byte) 11);

	private String name;
	private byte value;

	CardType(String name, byte value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public byte getValue() {
		return value;
	}

}

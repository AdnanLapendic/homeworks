package ba.bitcamp.homework17.task1;

import java.util.Arrays;

/**
 * This class was conceived to imitate StringBuilder class. CampStringBuilder
 * has only one attribute array of chars.
 * 
 * @author adnan.lapendic
 *
 */
public class CampStringBuilder extends Object {
	private char[] characters;

	/**
	 * CampStringBuilder constructor.
	 * 
	 * @param characters
	 *            - Array of chars
	 */
	public CampStringBuilder(char[] characters) {

		this.characters = characters;
	}

	/**
	 * Get characters
	 * 
	 * @return
	 */
	public char[] getChatacters() {
		return characters;
	}

	/**
	 * Set characters
	 * 
	 * @param chatacters
	 */
	public void setChatacters(char[] chatacters) {
		this.characters = chatacters;
	}
	
	/**
	 * Put object in the end
	 * 
	 * @param o
	 *            - Object
	 */
	public void append(Object o) {
		char[] cc = o.toString().toCharArray();

		System.out.printf(Arrays.toString(characters) + Arrays.toString(cc));
	}


	/**
	 * Put object on the beginning
	 * 
	 * @param o
	 */
	public void prepend(Object o) {
		char[] cc = o.toString().toCharArray();

		System.out.printf(Arrays.toString(cc) + Arrays.toString(characters));
	}

	@Override
	public String toString() {
		return Arrays.toString(characters);

	}

}

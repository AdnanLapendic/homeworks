package ba.bitcamp.homework.weekend5.task1;

/**
 * Class Character represent one character in our story. Class has all getters,
 * setters, standard methods and killCharacter() and makeCharacterCapible()
 * Class also has four final static attributes, two String attributes and one boolean.
 * @author LAPA
 *
 */
public class Character extends StoryElement {

	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	public static final String IS_CAPABLE_OF = "Is capable";
	public static final String NOT_CAPABLE = "Not capable";
	protected String gender;
	private boolean isAlive = true;
	protected String isCapable;

	/**
	 * Constructor for object Character
	 * @param name Character name
	 * @param gender Character gender
	 * @param isCapible Is character capable or not
	 */
	public Character(String name, String gender, String isCapable) {
		super(name);
		this.gender = gender;
		this.isCapable = isCapable;
	}

	/**
	 * This method kills one character
	 * @param c
	 */
	public void killCharacter(Character c) {
		if (isAlive == true) {
			isAlive = false;
		}
	}

	/**
	 * This method change state of character from not capable to capable
	 */
	public void makeCharacterCapible() {
		if (isCapable.equals(NOT_CAPABLE) || isCapable.equals(null)) {
			isCapable = IS_CAPABLE_OF;
		}
	}

	/**
	 * Get characters gender
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set or change characters gender
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Is character alive or not
	 * @return
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Set or change is Character alive or not
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * Return if Character is capable or not
	 * @return
	 */
	public String getIsCapible() {
		return isCapable;
	}

	/**
	 * Set or change if Character is capable or not
	 * @param isCapible
	 */
	public void setIsCapible(String isCapible) {
		this.isCapable = isCapible;
	}

	
	public static String getMale() {
		return MALE;
	}

	public static String getFemale() {
		return FEMALE;
	}

	public static String getIsCapibleOf() {
		return IS_CAPABLE_OF;
	}

	public static String getNotCapible() {
		return NOT_CAPABLE;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (isAlive != other.isAlive)
			return false;
		if (isCapable == null) {
			if (other.isCapable != null)
				return false;
		} else if (!isCapable.equals(other.isCapable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Character: \n" + "Name=" + name + "\n" + "Gender=" + gender
				+ "\n" + "isAlive=" + isAlive + "\n" + "Capible? " + isCapable
				+ "\n";

	}

}

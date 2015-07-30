package ba.bitcamp.homework17.task6;

/**
 * This class represents cat. it extends class Pet and all its attributes. Class
 * Cat don't have any attributes or methods except toString method.
 * 
 * @author adnan.lapendic
 *
 */
public class Cat extends Pet {

	/**
	 * Constructor for object Cat. It uses attributes extended from superclass:
	 * name, age and species.
	 * 
	 * @param name 
	 * @param age
	 * @param species
	 */
	public Cat(String name, int age, String species) {
		super(name, age, species);
	}

	@Override
	public String toString() {
		return "Go away human";
	}

}

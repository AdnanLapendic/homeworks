package ba.bitcamp.homework17.task6;

/**
 * This class represents a dog. It extends Pet class and all its attributes and
 * methods. This class has only one attribute on its own, and that is breed.
 * Class has standard toString and equals methods.
 * 
 * @author adnan.lapendic
 *
 */
public class Dog extends Pet {

	private String breed;

	public Dog(String name, int age, String breed, String species) {
		super(name, age, species);
		this.breed = breed;
	}

	/**
	 * Get dog breed
	 * 
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * Set or change dog breed
	 * 
	 * @param breed
	 *            the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		return true;
	}

	public String toString() {
		return "Av av";
	}
}

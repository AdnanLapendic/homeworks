package ba.bitcamp.homework17.task6;

/**
 * This class is used to create Pet. Class has three attributes name, age
 * and species. It also has standard methods and all setters and getters.
 * 
 * @author adnan.lapendic
 *
 */
public class Pet {
	protected String name;
	protected int age;
	protected String species;

	/**
	 * Pet constructor. 
	 * @param name Pet name
	 * @param age Pet age
	 * @param species Pet species
	 */
	public Pet(String name, int age, String species) {
		super();
		this.name = name;
		this.age = age;
		this.species = species;
	}

	/** Get pet's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**Set or change pet's name
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Get pet's age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**Set or change pets age
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**Get pet's species
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**Set or change pet's species
	 * @param species
	 *            the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + ", species=" + species
				+ "]";
	}

}

package ba.bitcamp.homework17.tasks234;

/**
 * This class represents an author. It has private attributes name, Email and
 * gender and has final static attributes MALE and FEMALE. Class has setters,
 * getters, toString an equals method.
 * 
 * @author adnan.lapendic
 *
 */
public class Author {
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	private String name;
	private String eMail;
	private String gender;

	/**
	 * Constructs object Author with attributes name, eMail and gender.
	 * 
	 * @param name
	 *            - Author's name
	 * @param eMail
	 *            - Author's Email
	 * @param gender
	 *            - Author's gender
	 */
	public Author(String name, String eMail, String gender) {

		this.name = name;
		this.eMail = eMail;
		this.gender = gender;

	}

	/**
	 * Get Author's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change Author's name
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get Author's email
	 * 
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * Sets or change email
	 * 
	 * @param eMail
	 *            the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * Get Author's gender
	 * 
	 * @return the gender
	 */
	public String getGender() {
		if (gender == MALE) {
			return MALE;
		} else {
			return FEMALE;
		}
	}

	/**
	 * Set Author's gender
	 * 
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		String s = "";
		s += "Name: " + name + "\n";
		s += "Email: " + eMail + "\n";
		s += "Gender: " + gender + "\n";
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

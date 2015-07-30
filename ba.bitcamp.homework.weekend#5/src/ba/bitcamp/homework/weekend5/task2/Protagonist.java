package ba.bitcamp.homework.weekend5.task2;

import java.util.Arrays;

import ba.bitcamp.homework.weekend5.task1.Character;

/**
 * Class Protagonist represents main character in our story. This class has
 * getters, setters, toString and equals method. It also has killCharacter()
 * method and attainGoal() method.
 * 
 * @author LAPA
 *
 */
public class Protagonist extends Character {
	private String description = "Main character";
	private String goal;
	private Character[] helpers = new Character[4];;
	private Character enemy;
	private static int numOfHelpers = 0;

	/**
	 * Constructor for Protagonist
	 * 
	 * @param name
	 *            Protagonist name
	 * @param gender
	 *            Gender
	 * @param isCapible
	 *            is capable or not
	 * @param goal
	 *            his goal in story
	 */
	public Protagonist(String name, String gender, String isCapible, String goal) {
		super(name, gender, isCapible);
		this.goal = goal;
	}

	/**
	 * Returns main character description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set or change Protagonist description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets main goal in story
	 * 
	 * @return
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * Set or change goal in story
	 * 
	 * @param goal
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}

	/**
	 * Get array of characters who help Protagonist
	 * 
	 * @return
	 */
	public Character[] getHelpers() {
		return helpers;
	}

	/**
	 * Set or change helpers
	 * 
	 * @param helpers
	 */
	public void setHelpers(Character[] helpers) {
		this.helpers = helpers;
	}

	/**
	 * Get enemy
	 * 
	 * @return
	 */
	public Character getEnemy() {
		return enemy;
	}

	/**
	 * Set or change enemy
	 * 
	 * @param enemy
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	/**
	 * Add enemy
	 * 
	 * @param enemy
	 */
	public void addEnemy(Character enemy) {
		this.enemy = enemy;
	}

	/**
	 * Add character to list of Protagonists helpers
	 * 
	 * @param helper
	 */
	public void addHelper(Character helper) {
		if (numOfHelpers < 4) {
			if (helpers[numOfHelpers] == null) {
				helpers[numOfHelpers] = helper;
			}
			numOfHelpers++;
		} else {
			throw new IllegalArgumentException("Can't have more then 4 helpers");
		}
	}

	/**
	 * This is most important method in story, it calculates chance for success
	 * of main character, and what will happened if he succeed and what if he
	 * don't
	 * 
	 * @param p
	 */
	public void attainGoal(Protagonist p) {
		int chance = 0;
		if (p.isAlive() == true) {
			if (p.isCapable.equals(IS_CAPABLE_OF)) {
				chance += 40;
			}
			for (int i = 0; i < helpers.length; i++) {
				if (helpers[i] != null) {
					chance += 20;
				}
				if (chance >= 100) {
					chance = 100;
				}
			}
			if (enemy.getIsCapible().equals(IS_CAPABLE_OF)) {
				chance -= 30;
				if (chance < 0) {
					chance = 0;
				}
			}
			if (p.getGoal().equals(Goal.HARD)) {
				chance -= 20;
				if (chance < 0) {
					chance = 0;
				}
			}
			if (p.getGoal().equals(Goal.IMPOSSIBLE)) {
				chance -= 100;
				if (chance < 0) {
					chance = 0;
				}
			}
		} else {
			System.out.println("Main character is not alive");
		}

		if (chance >= 60) {
			System.out
					.println(p.name + " has successfuly accomplish " + p.goal);
			int i = (int) (Math.random() * 4 + 1);
			if (p.helpers[i].getIsCapible() == NOT_CAPABLE
					&& helpers[i] != null) {
				p.helpers[i].setIsCapible(IS_CAPABLE_OF);
			}

		} else {
			System.out.println(p.name + " did't accomplish his goal " + p.goal);
			int i = (int) (Math.random() * 4 + 1);
			killCharacter(p.helpers[i]);
		}
		int j = (int) (Math.random() * 4 + 1);
		if (p.helpers[j].getIsCapible() == NOT_CAPABLE && helpers[j] != null) {
			p.helpers[j].setIsCapible(IS_CAPABLE_OF);
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Protagonist other = (Protagonist) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enemy == null) {
			if (other.enemy != null)
				return false;
		} else if (!enemy.equals(other.enemy))
			return false;
		if (goal == null) {
			if (other.goal != null)
				return false;
		} else if (!goal.equals(other.goal))
			return false;
		if (!Arrays.equals(helpers, other.helpers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Protagonist: \n" + "Name=" + name + "\n" + "Gender=" + gender
				+ "\n" + "Description=" + description + "\n" + "Helpers="
				+ Arrays.toString(helpers) + "\n" + "Enemy=" + enemy + "\n";

	}

}

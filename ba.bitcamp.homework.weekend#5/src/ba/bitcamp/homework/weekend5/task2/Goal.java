package ba.bitcamp.homework.weekend5.task2;

import ba.bitcamp.homework.weekend5.task1.StoryElement;

/**
 * This class represent goal which main character need to accomplish 
 * @author LAPA
 *
 */
public class Goal extends StoryElement {
	public static final int EASY = 0;
	public static final int HARD = 1;
	public static final int IMPOSSIBLE = 2;
	private String goal;
	private int level;
	private Event event;
	private Character character;

	/**
	 * Goal constructor
	 * @param name Goal name
	 * @param goal Goal
	 * @param level level of difficulty
	 * @param event Event
	 * @param character Character
	 */
	public Goal(String name, String goal, int level, Event event,
			Character character) {
		super(name);
		this.goal = goal;
		this.level = level;
		this.event = event;
		this.character = character;

	}

	public String getGoal() {
		return goal;
	}

	public int getLevel() {
		return level;
	}

	public Event getEvent() {
		return event;
	}

	public Character getCharacter() {
		return character;
	}

}

package ba.bitcamp.homework.weekend5.task2;

import ba.bitcamp.homework.weekend5.task1.Character;

/**
 * Main class used to test other classes and methods
 * @author LAPA
 *
 */
public class Main {

	public static void main(String[] args) {

		Character ch1 = new Character("Adnan", Character.MALE,
				Character.IS_CAPABLE_OF);

		System.out.println(ch1);

		Protagonist p1 = new Protagonist("LapA", Character.MALE,
				Character.IS_CAPABLE_OF, Event.LOVE);
		System.out.println(p1);
		Protagonist enemy = new Protagonist("Saruman", Character.FEMALE, Character.NOT_CAPABLE, Event.REVENGE);
		p1.addEnemy(enemy);
		System.out.println(p1);
		Character c = new Character("Helper", Character.MALE, Character.IS_CAPABLE_OF);
		p1.addHelper(c);
		System.out.println(p1);
		Character c2 = new Character("Helper2", Character.FEMALE, Character.IS_CAPABLE_OF);
		p1.addHelper(c2);
		System.out.println(p1);
		
		p1.attainGoal(p1);
				
		System.out.println(c2);
		System.out.println(p1);
	}

}

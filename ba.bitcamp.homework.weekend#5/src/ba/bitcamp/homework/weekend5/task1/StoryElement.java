package ba.bitcamp.homework.weekend5.task1;

/**
 * Abstract class StoryElement represent one piece of story. Class has two constructors
 * @author LAPA
 *
 */
public abstract class StoryElement {
protected String name;

public StoryElement(String name){
	this.name=name;
}
public StoryElement(){
	this("STElement");
}
}

package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.Random;

/**
 * Class representing the insulting action of Goon.
 */
public class InsultAction extends Action{

	private Actor actor;
	private Actor subject;
	private Random rand = new Random();
	private String[] insults = {"You are dumb", "You are weak"};
	
	/**
	 * Constructor for the InsultAction class, which in an extension of the Action class.
	 * 
	 * @param actor actor who performs the insulting
	 */
	public InsultAction(Actor actor) {
		this.actor = actor;
	}
	
	/**
	 * Overridden method from the parent class to execute insulting the player.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		return actor + " says " + insults[rand.nextInt(insults.length)];
	}
	
	/**
	 * Overridden method from the parent class to return null returned when
	 * an insult is performed.
	 */
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of insulting the player.
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

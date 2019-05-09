package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

/**
 * Class representing the player that could be stunned by Ninja
 */
public class StunnablePlayer extends Player{

	private boolean isStunned = false;
	int stunCounter = 0;
	
	/**
	 * Super constructor for StunnablePlayer class extended from the Player class.
	 * 
	 * @param name name of the player
	 * @param displayChar character to represent the player in the UI
	 * @param priority how early in the turn the player can act
	 * @param hitPoints player's starting number of hitpoints
	 */
	public StunnablePlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	
	/**
	 * Mutates the isStunned field of the Player class.
	 * 
	 * @param b boolean value of true/false
	 */
	public void setIsStunned(boolean b) {
		isStunned = b;
	}
	
	/**
	 * Returns the value of the isStunned field.
	 * 
	 * @return boolean value of true/false
	 */
	public boolean getIsStunned() {
		return isStunned;
	}
	
	/**
	 * Overridden method from the parent class to make the player stunnable.
	 */
	@Override
	protected Action showMenu(Actions actions, Display display) {
		if (isStunned && stunCounter >= 2) {
			stunCounter = 0;
			isStunned = false;
		}
		
		if (isStunned) {
			stunCounter++;
			return new SkipTurnAction();
		}
		
		return super.showMenu(actions, display);
		
	}
}

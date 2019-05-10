package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Abstract class representing the non-player characters of the game.
 */
public abstract class NPC extends Actor{

	/**
	 * Super constructor of the NPC class extended from the Actor class.
	 * 
	 * @param name name of the non-player character
	 * @param displayChar character to display for this type of non-player character
	 */
	public NPC(String name, char displayChar) {
		super(name, displayChar, 1, 50);
	}
	
	/**
	 * List of behaviours of the non-player character.
	 */
	protected List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	/**
	 * Add behaviour to the non-player character's list of behaviours.
	 * 
	 * @param behaviour behaviour to be added.
	 */
	protected void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	/**
	 * Overridden method from parent class to change NPC's random action as a
	 * non-player character.
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// NPC will do its behaviours before action
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// if no behaviour are done, it skips its turn
		for (Action action : actions) {
			if (action instanceof SkipTurnAction) {
				return action;
			}
		}
		return null;
	}
	
	/**
	 * Overridden method from parent class to disable NPC from being attacked.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions();
	}

}

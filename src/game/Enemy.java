package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Abstract class representing enemies of the player.
 */
public abstract class Enemy extends Actor{
	protected static final int BASE_HITPOINTS = 50;
	
	/**
	 * Super constructor of the Enemy class extended from the Actor class.
	 * 
	 * @param name name of the enemy
	 * @param displayChar character to display for this type of enemy
	 */
	public Enemy(String name, char displayChar) {
		// this is enemies base priority and hitpoints
		// can be used as a reference for other type of enemy
		super(name, displayChar, 5, BASE_HITPOINTS);
	}
	
	/**
	 * Super constructor of the Enemy class extended from the Actor class with specific
	 * hit points declaration.
	 * 
	 * @param name name of the enemy
	 * @param displayChar character to display for this type of enemy
	 * @param hitPoints hit points of the enemy
	 */
	public Enemy(String name, char displayChar, int hitPoints) {
		super(name, displayChar, 5, hitPoints);
	}
	
	/**
	 * List of behaviours of the enemy.
	 */
	protected List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	/**
	 * Add behaviour to the enemy's list of behaviours.
	 * 
	 * @param behaviour behaviour to be added.
	 */
	protected void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	/**
	 * Overridden method from parent class to change enemy's random action as a
	 * non-player character.
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// enemy will do its behaviours before action
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// if no behaviour are done, either attack or skip turn
		for (Action action : actions) {
			if (action instanceof AttackAction) {
				return action;
			}
			if (action instanceof SkipTurnAction) {
				return action;
			}
		}
		return null;
	}
	
	/**
	 * Overridden method from parent class to let only Player to attack Enemy.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		// only player can attack enemy, enemy can't attack each other
		if (otherActor instanceof Player) {
			return new Actions(new AttackAction(otherActor, this));
		}
		return new Actions();
	}

}

package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the enemy Ninja.
 */
public class Ninja extends Enemy{

	Random rand = new Random();
	
	/**
	 * Super constructor of the Ninja extended from the Enemy class.
	 * <P>
	 * The method also adds an instance of MoveAwayBehaviour and an instance
	 * of ThrowPowderBehaviour to Ninja.
	 * 
	 * @param name
	 * @param player
	 */
	public Ninja(String name, Actor player) {
		super(name, 'N');
		addBehaviour(new MoveAwayBehaviour(player));
		addBehaviour(new ThrowPowderBehaviour(player));
	}
	
	/**
	 * Overridden method from parent class to change enemy's random action as a
	 * non-player character.
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		
		// ninja will either throw powder or move away from player each turn
		ActionFactory behaviour = actionFactories.get(rand.nextInt(actionFactories.size()));
	
		Action action = behaviour.getAction(this, map);
		if (action != null) {
			return action;
		}
		
		return new SkipTurnAction();
	}

}



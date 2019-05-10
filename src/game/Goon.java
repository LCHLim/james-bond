package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * Class representing the enemy Goon.
 */
public class Goon extends Enemy{
	private Random rand = new Random();
	
	/**
	 * Super constructor of the Goon extended from the Enemy class.
	 * <P>
	 * The method also adds an instance of FollowBehaviour to Goon.
	 * 
	 * @param name name of the Goon
	 * @param player player
	 */
	public Goon(String name, Actor player) {
		super(name, 'G');
		addBehaviour(new FollowBehaviour(player));
	}
	
	/**
	 * Overridden method from parent class to change enemy's random action as a
	 * non-player character.
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// 10 % of chance to invoke an insult
		if (rand.nextInt(10) == 0) {
			return new InsultAction(this);
		}
		
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
	 * Overridden method from the parent class to modify enemy's default damage to be
	 * twice as such.
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		int baseDamage = super.getIntrinsicWeapon().damage();
		return new IntrinsicWeapon(baseDamage * 2, "punches");
	}

}

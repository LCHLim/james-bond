package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * Class representing the enemy Goon.
 */
public class Goon extends Enemy{
	private Random rand = new Random();
	private Actor target;
	
	
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
		target = player;
		addBehaviour(new FollowBehaviour(target));
	}
	
	/**
	 * Overridden method from parent class to change enemy's random action as a
	 * non-player character.
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		Location here = map.locationOf(this);
        Location there = map.locationOf(target);
        
        // perform invoke only when same map as player. 
        // Eg. You can't insult actor who is in another Planet.
        try{
	        if (here.map().equals(there.map())) {
	        	
	        	// 10 % chance to invoke insult action
	        	if (rand.nextInt(10) == 0) {
	    			return new InsultAction();
	    		}
	        }
        }
        catch (Exception ex) {}
		
		
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

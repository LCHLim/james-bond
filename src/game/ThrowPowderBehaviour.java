package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

/**
 * Class representing throw powder behaviour of actors.
 */
public class ThrowPowderBehaviour extends Action implements ActionFactory{

	private StunnablePlayer target;
	Random rand = new Random();
	
	/**
	 * Constructor for the ThrowPowderBehaviour class, which is implemented from the
	 * ActionFactory interface.
	 * 
	 * @param subject actor on whom the throw powder behaviour is shown
	 */
	public ThrowPowderBehaviour(Actor subject) {
		this.target = (StunnablePlayer)subject;
	}

	/**
	 * Overridden method from the interface ActionFactory.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		try {
			Location here = map.locationOf(actor);
			Location there = map.locationOf(target);
						
			// won't perform this behaviour if they are not in the same map.
            if (!here.map().equals(there.map())) {
            	return null;
            }
			
			Range xs, ys;
			if (distance(here,there) < 5) {
				xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
				ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);
				
				for (int x : xs) {
					for (int y : ys) {
						if(map.at(x, y).getGround().blocksThrownObjects())
							return null;
					}
				}
				return this;
			}
		} catch (Exception ex) {}
		return null;
	}

	/**
	 * Overridden method from the parent class to execute throw powder behaviour.
	 * <P>
	 * Returns strings when the enemy stuns the player or when the enemy misses
	 * the player or even when the player is already stunned.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		if (rand.nextBoolean()) {
			
			if (target.getIsStunned()) {
				return target + "is already stunned, the stun powder has no effect.";
			}
			
			target.setIsStunned(true);
			return target + " has been stunned by " + actor + " for 2 rounds.";
		}
		
		return actor + " missed " + target;
	}

	/**
	 * Overridden method from the parent class to get a string returned when
	 * the player stuns the target.
	 */
	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the behaviour of throwing stun powder.
	 */
	@Override
	public String hotKey() {
		return "";
	}
	
	/**
	 * Calculates the Manhattan distance between two locations.
	 * 
	 * @param a first of the two locations between which the Manhattan distance is calculated
	 * @param b second of the two locations between which the Manhattan distance is calculated
	 * @return the calculated Manhattan distance
	 */
	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}

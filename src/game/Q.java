package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the non-player character Q.
 */
public class Q extends NPC{

	/**
	 * Super constructor of the Q class extended from the NPC class.
	 * <P>
	 * The method also adds an instance of WanderBehaviour to Q.
	 * 
	 * @param name name of the non-player character
	 */
	public Q(String name) {
		super(name, 'Q');
		addBehaviour(new WanderBehaviour());
	}

	/**
	 * Overridden method from parent class to let only Player to talk to and give plans
	 * to Q.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		
		if (otherActor instanceof Player) {
			actions.add(new TalkAction(this));
			actions.add(new GivePlanAction(this));
		}
		return actions;
	}
}

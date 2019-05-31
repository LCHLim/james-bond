package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;


/**
 * Class representing the moonbase
 */
public class Crater extends Ground {

	/**
	 * Constructor of Crater
	 */
	public Crater() {
		super('o');
	}
	
	/**
	 * Overridden method to allow only actors with skill 'SpaceTraveller' to enter
	 */
	@Override
	public boolean canActorEnter(Actor a) {
		return a.hasSkill(GameSkills.SPACETRAVELLER);
	}
	
}

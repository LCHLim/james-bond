package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * Class representing the walls on the map.
 */
public class Wall extends Ground {
	
	/**
	 * Super constructor of the Wall class extended from the Ground class.
	 */
	public Wall() {
		super('#');
	}
	
	/**
	 * Overridden the method the from parent class to implement Wall to be impassable terrain.
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	/**
	 * Overridden the method from the parent class to implement Wall to be terrain that blocks thrown objects.
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}

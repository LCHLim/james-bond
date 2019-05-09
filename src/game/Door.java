package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the doors on the map.
 */
public class Door extends Ground{
	
	/**
	 * Super constructor of the Door class extended from the Ground class.
	 */
	public Door() {
		super('+');
	}
	
	/**
	 * Overridden method from parent class to implement Door to be terrain that is
	 * only passable if conditions are met.
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	/**
	 *  Overridden method from the parent class to implement Door to be terrain that
	 *  blocks thrown objects.
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
	
	/**
	 * Overridden method from the parent class to implement allowable actions on Door.
	 * <P>
	 * An instance of UnlockDoorAction is created as an allowable action on Door if the Actor considered is an instance of Player.
	 * <P>
	 * Returns an empty Action list otherwise.
	 * 
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the Door from the Actor
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		if (actor instanceof Player) {
			return new Actions(new UnlockDoorAction(direction, location));
		}
		return new Actions();
	}
		
		
}

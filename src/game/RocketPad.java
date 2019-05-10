package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the rocket pad.
 */
public class RocketPad extends Ground{
	
	/**
	 * Super constructor of the RocketPad class extended from the Ground class.
	 */
	public RocketPad() {
		super('R');
	}
	
	/**
	 * Overridden method from the parent class to implement allowable actions on RocketPad.
	 * <P>
	 * An instance of BuildRocketAction is created as an allowable action on RocketPad if the Actor considered
	 * is an instance of Player.
	 * <P>
	 * Returns an empty Action list otherwise.
	 * 
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the RocketPad from the Actor
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		if (actor instanceof Player) {
			return new Actions(new BuildRocketAction(location));
		}
		return new Actions();
	}

}

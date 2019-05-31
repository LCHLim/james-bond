package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Class representing water ground type
 */
public class Water extends Ground {
	
	/**
	 * Constructor of Water
	 */
	public Water() {
		super('~');
	}
	
	/**
	 * Overridden method to check whether if actor could enter this type of ground
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	
	/**
	 * Overridden to check whether if it blocks thrown objects
	 */
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}
	
	
	/**
	 * Overridden method to give allowable actions to particular actors
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		
		if (actor instanceof Player) {
			List<Item> items = actor.getInventory();
			
			for (Item item : items) {
				if (item.toString().equals("Water Pistol")) {
					return new Actions(new FillWaterPistolAction(item));
				}
			}
		}
		
		return super.allowableActions(actor, location, direction);
	}

}

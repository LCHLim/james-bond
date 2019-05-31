package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Class representing the rocket building action of the player.
 */
public class BuildRocketAction extends Action{
	private Location here;
	private Item rocket;

	/**
	 * Constructor for the BuildRocketAction class, which in an extension of the Action class.
	 * @param location location at which the rocket is to be built
	 * @param rocket a rocket object
	 */
	public BuildRocketAction(Location location, Item rocket) {
		here = location;
		this.rocket = rocket;
	}
	
	/**
	 * Overridden method from the parent class to execute rocket build action if
	 * the player has eligible items in the inventory, ie. a rocket engine and
	 * a rocket body.
	 * <P>
	 * Returns strings when the player build the rocket with or without the engine
	 * and the body in hand specifically.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = here.getItems();
		String[] itemRequired = {"Rocket Engine", "Rocket Body"};
		ArrayList<Item> toBeRemovedItems = new ArrayList<Item> ();
		
		// record the item that need to be removed
		for (Item item : items) {
			String itemName = item.toString();
			if (itemName.equals(itemRequired[0]) || itemName.equals(itemRequired[1])) {
				toBeRemovedItems.add(item);
			}
		}
		
		// if item to be removed is less than item required, action failed.
		if (toBeRemovedItems.size() < itemRequired.length) {
			return "Rocket build failed." + System.lineSeparator() +
					"Required both " + itemRequired[0] + " and " + itemRequired[1] +
					" on the Rocket Pad.";
		} else {
			// remove item from location
			for (Item item : toBeRemovedItems) {
				here.removeItem(item);
			}
			
			// put rocket at the location
			map.addItem(rocket, here.x(), here.y());
			return actor + " has successfully built the rocket !";
		}
	}

	/**
	 * Overridden method to show the action's description on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " builds rocket";
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of build a rocket.
	 */
	@Override
	public String hotKey() {
		return "";
	}


}

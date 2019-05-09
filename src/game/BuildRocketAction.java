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
	Location here;
	
	/**
	 * Constructor for the BuildRocketAction class, which in an extension of the Action class.
	 * 
	 * @param location location at which the rocket is to be built
	 */
	public BuildRocketAction(Location location) {
		here = location;
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
		
		for (Item item : items) {
			String itemName = item.toString();
			if (itemName.equals(itemRequired[0]) || itemName.equals(itemRequired[1])) {
				toBeRemovedItems.add(item);
			}
		}
		
		if (toBeRemovedItems.size() < itemRequired.length) {
			return "Rocket build failed." + System.lineSeparator() +
					"Required both " + itemRequired[0] + " and " + itemRequired[1] +
					" on the Rocket Pad.";
		} else {
			for (Item item : toBeRemovedItems) {
				here.removeItem(item);
			}
			Item rocket = Item.newFurniture("Rocket", '^');
			map.addItem(rocket, here.x(), here.y());
			return actor + " has successfully built the rocket !";
		}
	}

	/**
	 * Overridden method from the parent class to get a string returned when
	 * the player builds the rocket.
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " builds rocket";
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of building a rocket.
	 */
	@Override
	public String hotKey() {
		return "";
	}


}

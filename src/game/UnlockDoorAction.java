package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Class representing the door unlocking action of the player.
 */
public class UnlockDoorAction extends Action{
	
	private String direction;
	private Location doorLocation;
	
	/**
	 * Constructor for the UnlockDoorAction class, which in an extension of the Action class.
	 * 
	 * @param direction direction the actor is acting
	 * @param doorLocation location of the door
	 */
	public UnlockDoorAction(String direction, Location doorLocation) {
		this.direction = direction;
		this.doorLocation = doorLocation;
	}

	/**
	 * Overridden method from the parent class to execute unlocking of door if the
	 * player has an eligible item in the inventory, ie. a key.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = actor.getInventory();
		
		for (Item item : items) {
			if (item.toString().equals("Key")) {
				actor.removeItemFromInventory(item);
				
				map.add(new Floor(), doorLocation);
				return "The door is unlocked !";
			}
		}
		return "Unlock failed." + System.lineSeparator() + "Key is required to open the door";
	}

	/**
	 * Overridden method from the parent class to get a string returned when
	 * a door is unlocked.
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " unlocks the door at the " + direction;
	}

	/**
	 * Overriden method from the parent class to return the key used in the menu
	 * for triggering the action unlocking a door.
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

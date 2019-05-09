package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Class representing the give plan action of the player.
 */
public class GivePlanAction extends Action{
	Actor subject;
	
	/**
	 * Constructor for the GivePlanAction class, which in an extension of the Action class.
	 * 
	 * @param subject actor on whom the plan giving action is performed on
	 */
	public GivePlanAction(Actor subject) {
		this.subject = subject;
	}
	
	/**
	 * Overridden method from the parent class to execute plan giving action if the
	 * player has an eligible item in the inventory, ie. a rocket plan.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = actor.getInventory();
		
		for (Item item : items) {
			if (item.toString().equals("Rocket Plan")) {
				actor.removeItemFromInventory(item);
				actor.addItemToInventory(Item.newInventoryItem("Rocket Body", 'B'));
				map.removeActor(subject);
				return subject + " gave rocket body to " + actor + " and disappeared with a cherry wave.";
			}
		}
		return subject + ": You do not have a rocket plan!";
	}

	/**
	 * Overridden method from the parent class to get a string returned when
	 * a plan is given to the desired party.
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " gives rocket plan to " + subject;
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of giving rocket plan.
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

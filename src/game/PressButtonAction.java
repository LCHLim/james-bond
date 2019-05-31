package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Action for pressing the oxygen dispenser's button
 */
public class PressButtonAction extends Action {
	
	/**
	 * Overridden method to press the button
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
			Location here = map.locationOf(actor);
			List<Item> items = here.getItems();
			
			for (Item item : items) {
				if (item.getClass() == OxygenTank.class) {
					return "Button does not work :(\nThere is already an oxygen tank !";
				}
			}
			
			here.addItem(new OxygenTank());
			return actor + " presses the button of Oxygen Dispencer";
	}

	/**
	 * Overridden method to show the action's description on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " presses the button of Oxygen Dispencer";
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of press button
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

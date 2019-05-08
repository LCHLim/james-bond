package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class BuildRocketAction extends Action{
	Location here;
	
	public BuildRocketAction(Location location) {
		here = location;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = here.getItems();
		ArrayList<Item> toBeRemovedItems = new ArrayList<Item> ();
		
		for (Item item : items) {
			String itemName = item.toString();
			if (itemName.equals("Rocket Engine") || itemName.equals("Rocket Body")) {
				toBeRemovedItems.add(item);
			}
		}
		
		for (Item item : toBeRemovedItems) {
			here.removeItem(item);
		}
		
		return actor + " has successfully built the rocket !";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " builds rocket";
	}

	@Override
	public String hotKey() {
		return "";
	}


}

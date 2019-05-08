package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class GivePlanAction extends Action{
	Actor subject;
	
	public GivePlanAction(Actor subject) {
		this.subject = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = actor.getInventory();
		
		for (Item item : items) {
			if (item.toString().equals("Rocket Plan")) {
				actor.removeItemFromInventory(item);
				actor.addItemToInventory(Item.newInventoryItem("Rocket Body", 'B'));
			}
		}
		return subject + " gave the plan to " + actor + " and disappear with a cherry wave.";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " gets rocket plan from " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

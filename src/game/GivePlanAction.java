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
				map.removeActor(subject);
				return subject + " gave rocket body to " + actor + " and disappear with a cherry wave.";
			}
		}
		return subject+ ": You do not have a rocket plan !";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " gives rocket plan to " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

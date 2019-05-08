package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class UnlockDoorAction extends Action{
	Door door;
	
	public UnlockDoorAction(Door door) {
		this.door = door;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = actor.getInventory();
		
		for (Item item : items) {
			if (item.toString().equals("Key")) {
				actor.removeItemFromInventory(item);
				door.setIsPassable(true);
				return actor + " has succesfully unlocked the door !";
			}
		}
		return "";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " unlocks the door.";
	}

	@Override
	public String hotKey() {
		return "";
	}

}

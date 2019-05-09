package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class UnlockDoorAction extends Action{
	
	private String direction;
	private Location doorLocation;
	
	public UnlockDoorAction(String direction, Location doorLocation) {
		this.direction = direction;
		this.doorLocation = doorLocation;
	}

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

	@Override
	public String menuDescription(Actor actor) {
		return actor + " unlocks the door at the " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

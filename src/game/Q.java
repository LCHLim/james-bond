package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class Q extends NPC{

	public Q(String name) {
		super(name, 'Q');
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		
		if (otherActor instanceof Player) {
			actions.add(new TalkAction(this));
			
			List<Item> items = otherActor.getInventory();
			
			for (Item item : items) {
				if (item.toString().equals("Rocket Plan")) {
					actions.add(new GivePlanAction(this));
				}
			}
		}
		return actions;
	}
}

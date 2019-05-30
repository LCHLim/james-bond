package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class Water extends Ground {
	
	public Water() {
		super('~');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		
		if (actor instanceof Player) {
			List<Item> items = actor.getInventory();
			
			for (Item item : items) {
				if (item.toString().equals("Water Pistol")) {
					return new Actions(new FillWaterPistolAction(item));
				}
			}
		}
		
		return super.allowableActions(actor, location, direction);
	}

}

package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class Door extends Ground{
	private boolean isPassable = false;
	
	public Door() {
		super('$');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return isPassable;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return !isPassable;
	}
	
	public void setIsPassable(boolean b) {
		isPassable = b;
	}

	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		if (actor instanceof Player) {
			List<Item> items = actor.getInventory();
			
			for (Item item : items) {
				if (item.toString().equals("Key")) {
					return new Actions(new UnlockDoorAction(this));
				}
			}
		}
		return new Actions();
	}
}

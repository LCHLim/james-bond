package game;

import edu.monash.fit2099.engine.*;

public class Door extends Ground{
	
	public Door() {
		super('+');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
	

	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		if (actor instanceof Player) {
			return new Actions(new UnlockDoorAction(direction, location));
		}
		return new Actions();
	}
		
		
}

package game;

import edu.monash.fit2099.engine.*;

public class RocketPad extends Ground{

	public RocketPad() {
		super('R');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		if (actor instanceof Player) {
			return new Actions(new BuildRocketAction(location));
		}
		return new Actions();
	}

}

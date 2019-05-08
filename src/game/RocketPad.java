package game;

import java.util.*;
import edu.monash.fit2099.engine.*;

public class RocketPad extends Ground{

	public RocketPad() {
		super('R');
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		List<Item> items = location.getItems();
		int requiredItemCount = 2;
	
		for (Item item : items) {
			String itemName = item.toString();
			
			if (itemName.equals("Rocket Engine") || itemName.equals("Rocket Body")) {
				requiredItemCount--;
			}
		}
		
		
		if (actor instanceof Player && requiredItemCount== 0) {
			return new Actions(new BuildRocketAction(location));
		}
		
		return new Actions();
	}

}

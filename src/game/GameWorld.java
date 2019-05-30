package game;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.World;

public class GameWorld extends World {

	public GameWorld(Display display) {
		super(display);
	}
		
	
	@Override
	protected String endGameMessage() {
		StunnablePlayer p = (StunnablePlayer) player;
		
		if (p.getHitPoints() <= 0) {
			return p + " loses";
		}
		
		for (Item item : p.getInventory()) {
			if (item.toString().equals("Sleeping Yugo Maxx")) {
				return p + " wins";
			}
		}
		
		return player + " quits the game";
	}
	
	

	

}

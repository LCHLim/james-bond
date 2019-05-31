package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the game world, including the locations of all Actors, the player, and the playing grid.
 * It allows the game to have more variety of ending.
 */
public class GameWorld extends World {

	/**
	 * Overridden class constructor 
	 * @param display a display instance
	 */
	public GameWorld(Display display) {
		super(display);
	}
	
	/**
	 * Overridden method from parent class to perform 3 ways of end game messages
	 * @return
	 */
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

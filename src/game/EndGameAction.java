package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action to allow the game to end earlier without having Player being knocked out by enemies 
 *
 */
public class EndGameAction extends Action {
	
	/**
	 * Overridden method from parent class to perform implicitly End Game action 
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		map.removeActor(actor);
		return "";
	}

	/**
	 * Overridden method to show the action's description on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return "Quit Game";
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of quit game.
	 */
	@Override
	public String hotKey() {
		return "1";
	}

}

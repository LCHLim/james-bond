package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Action to fill up the water pistol
 */
public class FillWaterPistolAction extends Action {
	private Item waterPistol;
	
	/**
	 * Constructor of FillWaterPistol Action
	 * @param waterPistol a water pistol item
	 */
	public FillWaterPistolAction(Item waterPistol) {
		this.waterPistol = waterPistol;
		
	}

	/**
	 * Overridden method to fill up the empty water pistol
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		
		if (waterPistol.hasSkill(GameSkills.WATERSHOOTER)) {
			return waterPistol + " is already full !";
		}
		
		waterPistol.addSkill(GameSkills.WATERSHOOTER);
		return actor + " fills up the empty " + waterPistol;
	}

	/**
	 * Overridden method to show the action's description on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " fills up the empty " + waterPistol;
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of filling water pistol
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

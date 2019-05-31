package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

/**
 * Action to squirt the water from the water pistol on Yugo Maxx.
 * It will have a 70% chance of destroying Yugo Maxx's exoskeleton.
 */
public class SquirtWaterAction extends Action {
	private Actor target;
	private Item exoskeleton;
	private Item waterPistol;
	private Random rand =  new Random();
	
	/**
	 * Constructor of SquirtWaterAction
	 * @param target the target to squirt water on
	 * @param exoskeleton a reference of Yugo Maxx's exoskeleton
	 * @param waterPistol a reference of water pistol item
	 */
	public SquirtWaterAction(Actor target, Item exoskeleton, Item waterPistol) {
		this.target = target;
		this.exoskeleton = exoskeleton;
		this.waterPistol = waterPistol;
	}

	
	/**
	 * Overridden to destroy Yugo Maxx's exoskeleton
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		if (waterPistol.hasSkill(GameSkills.WATERSHOOTER)) {
			waterPistol.removeSkill(GameSkills.WATERSHOOTER);
			
			if (rand.nextDouble() < 0.7) {
				target.removeItemFromInventory(exoskeleton);
				return actor + " squirts water onto " + target +
						"\n" + target + "'s exoskeleton destroyed :D";
			} else {
				return actor + " missed " + target;
			}
		} else {
			return waterPistol + " is empty!";
		}
	}

	
	/**
	 * Overridden method to show the action's description on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " squirts water onto " + target;
	}

	
	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of squirt water
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

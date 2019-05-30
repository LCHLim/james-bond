package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

public class SquirtWaterAction extends Action {
	private Actor target;
	private Item exoskeleton;
	private Item waterPistol;
	private Random rand =  new Random();
	
	public SquirtWaterAction(Actor target, Item exoskeleton, Item waterPistol) {
		this.target = target;
		this.exoskeleton = exoskeleton;
		this.waterPistol = waterPistol;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (waterPistol.hasSkill(GameSkills.WATERSHOOTER)) {
			waterPistol.removeSkill(GameSkills.WATERSHOOTER);
			
			if (rand.nextDouble() < 0.7) {
				target.removeItemFromInventory(exoskeleton);
				return actor + " squirts water onto " + target;
			} else {
				return actor + " missed " + target;
			}
		} else {
			return waterPistol + " is empty!";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " squirts water onto " + target;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

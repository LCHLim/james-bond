package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FillWaterPistolAction extends Action {
	private Item waterPistol;
	
	public FillWaterPistolAction(Item waterPistol) {
		this.waterPistol = waterPistol;
		
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		if (waterPistol.hasSkill(GameSkills.WATERSHOOTER)) {
			return waterPistol + " is already full !";
		}
		
		waterPistol.addSkill(GameSkills.WATERSHOOTER);
		return actor + " fills up the empty " + waterPistol;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fills up the empty " + waterPistol;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ThrowPowderAction extends Action{
	
	private StunnablePlayer target;
	Random rand = new Random();
	
	public ThrowPowderAction(Actor subject) {
		target = (StunnablePlayer) subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (rand.nextBoolean()) {
			
			if (target.getIsStunned()) {
				return target + "is already stunned, the stun powder has no effect.";
			}
			
			target.setIsStunned(true);
			return target + " has been stunned by " + actor + " for 2 rounds.";
		}
		
		return actor + " missed " + target;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	@Override
	public String hotKey() {
		return "";
	}

}

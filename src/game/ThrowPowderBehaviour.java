package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

public class ThrowPowderBehaviour extends Action implements ActionFactory{

	private StunnablePlayer target;
	Random rand = new Random();
	
	public ThrowPowderBehaviour(Actor subject) {
		this.target = (StunnablePlayer)subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
					
		Range xs, ys;
		if (distance(here,there) < 5) {
			xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
			ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);
			
			for (int x : xs) {
				for (int y : ys) {
					if(map.at(x, y).getGround().blocksThrownObjects())
						return null;
				}
			}
			return this;
		}
		return null;
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
	
	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}

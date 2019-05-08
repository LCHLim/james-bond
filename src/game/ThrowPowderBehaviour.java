package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

public class ThrowPowderBehaviour implements ActionFactory{

	private StunnablePlayer target;
	Random rand = new Random();
	
	public ThrowPowderBehaviour(Actor subject) {
		this.target = (StunnablePlayer)subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
					
		if (distance(here,there) < 5) {
			return new ThrowPowderAction(target);
		}
		return null;
	}

	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}

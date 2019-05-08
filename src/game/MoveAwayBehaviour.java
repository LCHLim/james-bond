package game;

import edu.monash.fit2099.engine.*;

public class MoveAwayBehaviour implements ActionFactory{
	
	private Actor target;
	
	public MoveAwayBehaviour(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		
		int currentDistance = distance(here, there);
		if (currentDistance < 5) {
			
			Exit maxDistanceExit = here.getExits().get(0);
			int maxDistance = 0;
			for (Exit exit : here.getExits()) {
				Location destination = exit.getDestination();
				
				if (destination.canActorEnter(actor)) {
					int newDistance = distance(destination, there);
					
					if (newDistance > maxDistance) {
						maxDistance = newDistance;
						maxDistanceExit = exit;
					}
				}
			}
			return new MoveActorAction(maxDistanceExit.getDestination(), maxDistanceExit.getName());
		}
		return null;
	}
	
	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}

}

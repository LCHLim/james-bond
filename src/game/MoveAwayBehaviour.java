package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing move away behaviour of actors.
 */
public class MoveAwayBehaviour implements ActionFactory{
	
	private Actor target;
	
	/**
	 * Constructor for the MoveAwayBehaviour class, which is implemented from the
	 * ActionFactory interface.
	 * 
	 * @param subject actor from whom the move away behaviour is shown
	 */
	public MoveAwayBehaviour(Actor subject) {
		this.target = subject;
	}
	
	/**
	 * Overridden method from the interface ActionFactory.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		
		// this condition check whether if ninja could "see" player within 5 squares of them
		Range xs, ys;
		if (distance(here, there) < 5) {
			xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
			ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);
			
			for (int x : xs) {
				for (int y : ys) {
					if(map.at(x, y).getGround().blocksThrownObjects())
						return null;
				}
			}
			
			// java will run this code if they could see the player
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
	
	/**
	 * Calculates the Manhattan distance between two locations.
	 * 
	 * @param a first of the two locations between which the Manhattan distance is calculated
	 * @param b second of the two locations between which the Manhattan distance is calculated
	 * @return the calculated Manhattan distance
	 */
	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}

}

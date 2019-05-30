package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing follow behaviour of actors.
 */
public class FollowBehaviour implements ActionFactory {

	private Actor target;

	/**
	 * Constructor for the FollowBehaviour class, which is implemented from the
	 * ActionFactory interface.
	 * 
	 * @param subject actor on whom the follow behaviour is shown
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	/**
	 * Overridden method from the interface ActionFactory.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
        try{
            Location here = map.locationOf(actor);
            Location there = map.locationOf(target);
            
            // won't perform this behaviour if they are not in the same map.
            if (!here.map().equals(there.map())) {
            	return null;
            }

            int currentDistance = distance(here, there);
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)) {
                    int newDistance = distance(destination, there);
                    if (newDistance < currentDistance) {
                        return new MoveActorAction(destination, exit.getName());
                    }
                }
            }
        }
        catch(Exception ex)
        {}

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
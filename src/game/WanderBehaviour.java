package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import edu.monash.fit2099.engine.*;

/**
 * Class representing wander behaviour of actors.
 */
public class WanderBehaviour implements ActionFactory{

	Random rand = new Random();
	
	/**
	 * Overridden method from the interface ActionFactory.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		ArrayList<Exit> movableExits = new ArrayList<Exit>(); 
		
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				movableExits.add(exit);
			}
		}
		
		Exit randExit = movableExits.get(rand.nextInt(movableExits.size()));
		return new MoveActorAction(randExit.getDestination(), randExit.getName());
	}

}

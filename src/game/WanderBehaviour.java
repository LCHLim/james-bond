package game;

import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.*;


public class WanderBehaviour implements ActionFactory{

	Random rand = new Random();
	
	public WanderBehaviour() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		List<Exit> exits = here.getExits();
		
		Exit randExit = exits.get(rand.nextInt(exits.size()));
		return new MoveActorAction(randExit.getDestination(), randExit.getName());
	}

}

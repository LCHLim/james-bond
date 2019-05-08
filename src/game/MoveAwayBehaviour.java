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
		int xStart = (here.x() -5 < 0) ? 0 : here.x() - 5;
		int xEnd = here.x() + 5;
		int yStart = (here.y() - 5 < 0) ? 0 : here.y() - 5;
		int yEnd = here.y() + 5;
		
		return null;
	}

}

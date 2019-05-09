package game;

import edu.monash.fit2099.engine.*;

public class Q extends NPC{

	public Q(String name) {
		super(name, 'Q');
		addBehaviour(new WanderBehaviour());
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		
		if (otherActor instanceof Player) {
			actions.add(new TalkAction(this));
			actions.add(new GivePlanAction(this));
		}
		return actions;
	}
}

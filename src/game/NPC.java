package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

public abstract class NPC extends Actor{

	public NPC(String name, char displayChar) {
		super(name, displayChar, 5, 50);
	}
	
	protected List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	protected void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// NPC will do its behaviors before action
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// if no behavior are done, it skips its turn
		for (Action action : actions) {
			if (action instanceof SkipTurnAction) {
				return action;
			}
		}
		return null;
	}
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions();
	}

}

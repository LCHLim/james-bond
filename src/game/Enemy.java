package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

public abstract class Enemy extends Actor{
	protected static final int BASE_HITPOINTS = 50;
	
	public Enemy(String name, char displayChar) {
		// this is enemies base priority and hitpoints
		// can be used as a reference for other type of enemy
		super(name, displayChar, 5, BASE_HITPOINTS);
	}
	
	public Enemy(String name, char displayChar, int hitPoints) {
		super(name, displayChar, 5, hitPoints);
	}
	
	protected List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	protected void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// enemy will do its behaviors before action
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// if no behavior are done, either attack or skip turn
		for (Action action : actions) {
			if (action instanceof AttackAction) {
				return action;
			}
			if (action instanceof SkipTurnAction) {
				return action;
			}
		}
		return null;
	}
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		// only player can attack enemy, enemy can't attack each other
		if (otherActor instanceof Player) {
			return new Actions(new AttackAction(otherActor, this));
		}
		return new Actions();
	}

}

package game;

import java.util.Random;

import edu.monash.fit2099.engine.*;

public class Ninja extends Enemy{

	Random rand = new Random();
	
	public Ninja(String name, Actor player) {
		super(name, 'N');
		addBehaviour(new MoveAwayBehaviour(player));
		addBehaviour(new ThrowPowderBehaviour(player));
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		ActionFactory behaviour = actionFactories.get(rand.nextInt(actionFactories.size()));
		Action action = behaviour.getAction(this, map);
		if (action != null) {
			return action;
		}
		
		return new SkipTurnAction();
	}

}



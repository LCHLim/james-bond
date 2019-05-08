package game;

import edu.monash.fit2099.engine.Actor;

public class Ninja extends Enemy{

	public Ninja(String name, Actor player) {
		super(name, 'N');
		addBehaviour(new MoveAwayBehaviour(player));
	}

}



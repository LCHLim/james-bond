package game;

import edu.monash.fit2099.engine.Actor;


public class Grunt extends Enemy {

	// Grunts have 50 hitpoints and are always represented with a g
	public Grunt(String name, Actor player) {
		super(name, 'g');
		addBehaviour(new FollowBehaviour(player));
	}
}

package game;

import edu.monash.fit2099.engine.Actor;

/**
 * Class representing the enemy Grunt.
 */
public class Grunt extends Enemy {

	/**
	 * Super constructor of the Grunt extended from the Enemy class.
	 * <P>
	 * The method also adds an instance of FollowBehaviour to Grunt.
	 * 
	 * @param name name of the Grunt
	 * @param player player
	 */
	// Grunts have 50 hitpoints and are always represented with a g
	public Grunt(String name, Actor player) {
		super(name, 'g');
		addBehaviour(new FollowBehaviour(player));
	}
}

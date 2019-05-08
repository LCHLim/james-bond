package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class Goon extends Enemy{
	private Random rand = new Random();
	
	public Goon(String name, Actor player) {
		super(name, 'G');
		addBehaviour(new FollowBehaviour(player));
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// enemy will do its behaviors before action
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		// 10 % of chance to invoke an insult
		if (rand.nextInt(10) == 0) {
			return new InsultAction(this);
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
	protected IntrinsicWeapon getIntrinsicWeapon() {
		int baseDamage = super.getIntrinsicWeapon().damage();
		return new IntrinsicWeapon(baseDamage * 2, "punches");
	}

}

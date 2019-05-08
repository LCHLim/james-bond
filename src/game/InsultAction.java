package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.Random;

public class InsultAction extends Action{

	private Actor actor;
	private Actor subject;
	private Random rand = new Random();
	private String[] insults = {"You are dumb", "You are weak"};
	
	public InsultAction(Actor actor) {
		this.actor = actor;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		return actor + " says " + insults[rand.nextInt(insults.length)];
	}
	
	
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String hotKey() {
		return "";
	}

}

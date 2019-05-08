package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class TalkAction extends Action{
	Actor subject;
	
	public TalkAction(Actor subject) {
		this.subject = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		List<Item> items = actor.getInventory();
		
		for (Item item : items) {
			if (item.toString().equals("Rocket Plan")) {
				return subject + ": Hand them over, I don't have all day!";
			}
		}
		
		return subject + ": I can give you something that will help, but I'm going to need the plans.";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " talks to " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the talk action of the player.
 */
public class TalkAction extends Action{
	Actor subject;
	
	/**
	 * Constructor for the TalkAction class, which in an extension of the Action class.
	 * 
	 * @param subject actor on whom the talk action is performed on
	 */
	public TalkAction(Actor subject) {
		this.subject = subject;
	}

	/**
	 * Overridden method from the parent class to execute talk action.
	 * <P>
	 * Returns strings when the player talks with or without the plan in hand
	 * specifically.
	 */
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

	/**
	 * Overridden method from the parent class to get a string returned when
	 * the player talks to the desired party.
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " talks to " + subject;
	}

	/**
	 * Overridden method from the parent class to return the key used in the menu
	 * for triggering the action of talking.
	 */
	@Override
	public String hotKey() {
		return "";
	}

}

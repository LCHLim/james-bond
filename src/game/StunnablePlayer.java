package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

/**
 * Class representing the player that could be stunned by Ninja
 */
public class StunnablePlayer extends Player{

	private boolean isStunned = false;
	private int stunCounter = 0;
	private GameMap moon;
	private Location earthRocketLocation;
	
	
	
	/**
	 * Super constructor for StunnablePlayer class extended from the Player class.
	 * 
	 * @param name name of the player
	 * @param displayChar character to represent the player in the UI
	 * @param priority how early in the turn the player can act
	 * @param hitPoints player's starting number of hitpoints
	 * @param moon moon map reference
	 * @param earthRocketLocation location reference
	 */
	public StunnablePlayer(String name, char displayChar, int priority, int hitPoints, GameMap moon, Location earthRocketLocation) {
		super(name, displayChar, priority, hitPoints);
		this.moon = moon;
		this.earthRocketLocation = earthRocketLocation;
	}


	/**
	 * Mutates the isStunned field of the Player class.
	 * 
	 * @param b boolean value of true/false
	 */
	public void setIsStunned(boolean b) {
		isStunned = b;
	}
	
	/**
	 * Returns the value of the isStunned field.
	 * 
	 * @return boolean value of true/false
	 */
	public boolean getIsStunned() {
		return isStunned;
	}
	
	/**
	 * Getter of attribute hitPoints
	 * @return player current hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * Counts the remaining oxygen
	 * @return remaining amount of oxygen
	 */
	private int getRemainingOxygenCount() {
		List<Item> items = getInventory();
		
		int amount = 0;
		for (Item item : items) {
			if (item instanceof OxygenTank) {
				amount += ((OxygenTank) item).getValue();
			}
		}
		return amount;
	}
	
	/**
	 * Consume oxygen by 1 point
	 */
	private void consumeOxygen() {
		List<Item> items = getInventory();
		
		int i = 0;
		while (!(items.get(i) instanceof OxygenTank)) {
			i++;
		}
		
		OxygenTank oxygenTank = (OxygenTank) items.get(i);
		oxygenTank.decreaseValue();
		
		if (oxygenTank.isEmpty()) {
			this.removeItemFromInventory(oxygenTank);
		}
		
	}
	
	/**
	 * Overridden method to select action to perform in each turn.
	 * Used this method to apply some side effect on player
	 * and perform suitable actions in current environment.
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		display.println("HitPoints: " + hitPoints + "/" + maxHitPoints);
		display.println("Oxygen: " + getRemainingOxygenCount() + " Units");
		
		if (map.equals(moon)) {
			
			if (getRemainingOxygenCount() > 0) {
				consumeOxygen();
			}
			else {
				display.println("Do not have enough amount of oxygen :(");
				return new MoveActorAction(earthRocketLocation, "to Earth automatically by the safety system!");
			}
		} else {
			
			// On earth and Yugo Maxx unconscious body is inside inventory
			for (Item item : getInventory()) {
				if (item.toString().equals("Sleeping Yugo Maxx")) {
					return new EndGameAction();
				}
			}
		}
		
		return showMenu(actions, display);
	}
	
	/**
	 * Overridden method from the parent class to make the player stunnable.
	 * Additionally, allow player to quit the game by himself/herself.
	 */
	@Override
	protected Action showMenu(Actions actions, Display display) {
		if (isStunned && stunCounter >= 2) {
			stunCounter = 0;
			isStunned = false;
		}
		
		if (isStunned) {
			stunCounter++;
			return super.showMenu(new Actions(new SkipTurnAction()), display);
		}
		
		actions.add(new EndGameAction());
		
		return super.showMenu(actions, display);
		
	}
}

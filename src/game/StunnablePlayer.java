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
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		
		
		
		if (map.equals(moon)) {
			
			if (getRemainingOxygenCount() > 0)
				consumeOxygen();
			else
				return new MoveActorAction(earthRocketLocation, "to Earth!");
		}
		
		return showMenu(actions, display);
	}
	
	/**
	 * Overridden method from the parent class to make the player stunnable.
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
		
		return super.showMenu(actions, display);
		
	}
}

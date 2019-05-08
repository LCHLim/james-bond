package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

public class StunnablePlayer extends Player{

	boolean isStunned = false;
	
	public StunnablePlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	
	public void setIsStunned(boolean b) {
		isStunned = b;
	}
	
	@Override
	protected Action showMenu(Actions actions, Display display) {
		if (isStunned) {
			return new SkipTurnAction();
		}
		
		return super.showMenu(actions, display);
		
	}
}

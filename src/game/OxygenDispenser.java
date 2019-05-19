package game;

import edu.monash.fit2099.engine.Item;

public class OxygenDispenser extends Item {
	private boolean buttonPressed = false;
	
	public OxygenDispenser() {
		super("oxygen dispenser", 'W');
		allowableActions.clear();
	}
	
	public boolean isButtonPressed() {
		return buttonPressed;
	}
	
	

	

}

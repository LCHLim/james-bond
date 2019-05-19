package game;

import edu.monash.fit2099.engine.Actions;
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
	
	public void pressButton() {
		buttonPressed = true;
	}
	
	public void unpressButton() {
		buttonPressed = false;
	}
	
	@Override
	public Actions getAllowableActions() {
		Actions actions = new Actions(new PressButtonAction(this));
		
		if (buttonPressed) {
			actions.add(new GetOxygenTankAction(this));
		}

		return actions;
	}

	

}

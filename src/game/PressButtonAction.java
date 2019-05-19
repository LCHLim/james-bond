package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class PressButtonAction extends Action {
	private OxygenDispenser target;
	
	public PressButtonAction(Item target) {
		this.target = (OxygenDispenser) target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (target.isButtonPressed()) {
			return "Button is pressed";
		} else {
			target.pressButton();
			return actor + " pressed the button";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " presses the button of " + target;
	}

	@Override
	public String hotKey() {
		return "";
	}

}

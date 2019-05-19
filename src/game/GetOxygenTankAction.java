package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class GetOxygenTankAction extends Action {
	private OxygenDispenser target;
	
	public GetOxygenTankAction(Item target) {
		this.target = (OxygenDispenser) target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		target.unpressButton();
		
		OxygenTank oxygenTank = new OxygenTank();
		oxygenTank.getAllowableActions().clear();
		oxygenTank.getAllowableActions().add(new DropItemAction(oxygenTank));
	
		actor.addItemToInventory(oxygenTank);
		return actor + " picked up the full oxygen tank";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " picks up the full oxygen tank";
	}

	@Override
	public String hotKey() {
		return "";
	}

}

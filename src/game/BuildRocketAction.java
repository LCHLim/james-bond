package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class BuildRocketAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		return actor + "has successfully built the rocket !";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + "builds rocket";
	}

	@Override
	public String hotKey() {
		return "";
	}


}

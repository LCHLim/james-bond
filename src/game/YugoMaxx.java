package game;

import edu.monash.fit2099.engine.*;

public class YugoMaxx extends Enemy {

	public YugoMaxx(String name) {
		super(name, 'Y');
		addBehaviour(new WanderBehaviour());
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
	
		for (Action action : actions) {
			if (action instanceof AttackAction) {
				return action;
			}
		}
			
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return new SkipTurnAction();
	}
	
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		int baseDamage = super.getIntrinsicWeapon().damage();
		return new IntrinsicWeapon(baseDamage * 2, "punches");
	}
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Item waterPistol = null;
		Item exoskeleton = null;
		
		
		if (otherActor instanceof Player) {
			for (Item item : otherActor.getInventory()) {
				if (item.toString().equals("Water Pistol")) {
					waterPistol = item;
					break;
				}
			}
		}
		
		for (Item item : getInventory()) {
			if (item.toString().equals("Exoskeleton")) {
				exoskeleton = item;
				break;
			}
		}
		
		if (waterPistol != null && exoskeleton != null) {
			return new Actions(new SquirtWaterAction(this, exoskeleton, waterPistol));
		}
		
		if (hasSkill(GameSkills.INVULNERABLE)) {
			return new Actions();
		}
		
		return super.getAllowableActions(otherActor, direction, map);
		
	}

	

}

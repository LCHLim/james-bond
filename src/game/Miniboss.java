package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;

public class Miniboss extends Enemy{

	public Miniboss(String name) {
		super(name, 'M', Enemy.BASE_HITPOINTS / 2);
	}
	
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		int baseDamage = super.getIntrinsicWeapon().damage();
		return new IntrinsicWeapon(baseDamage / 2 , "punches");
	}

	
}

package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;

/**
 * Class presenting the enemy Miniboss.
 */
public class Miniboss extends Enemy{
	
	/**
	 * Super constructor of the Miniboss class extended from the Enemy class.
	 * 
	 * @param name name of the Miniboss
	 */
	public Miniboss(String name) {
		super(name, 'M', Enemy.BASE_HITPOINTS / 2);
	}
	
	/**
	 * Overridden method from the parent class to modify enemy's default damage to be
	 * half as such.
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		int baseDamage = super.getIntrinsicWeapon().damage();
		return new IntrinsicWeapon(baseDamage / 2 , "punches");
	}

	
}

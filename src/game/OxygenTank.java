package game;

import edu.monash.fit2099.engine.Item;

/**
 * Class representing the oxygen tank
 *
 */
public class OxygenTank extends Item {
	private int value = 10;
	
	/**
	 * Constructor of OxygenTank
	 */
	public OxygenTank() {
		super("Oxygen Tank", '=');
	}

	/**
	 * Get the remaining amount of oxygen of this oxygen tank
	 * @return remaining amount of oxygen of this oxygen tank
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Method to decrease the remaining oxygen by 1 point
	 */
	public void decreaseValue() {
		if (!isEmpty()) {
			value--;
		}
	}
	
	/**
	 * Checker to check whether the oxygen tank has been used up
	 * @return true if it is empty else false
	 */
	public boolean isEmpty() {
		return value <= 0;
	}


	
	
	
	

	

}

package game;

import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {
	private int value = 10;
	
	public OxygenTank() {
		super("Oxygen Tank", 'H');

	}

	public boolean decreaseValue() {
		if (value > 0) {
			value--;
			return true;
			
		} else {
			return false;
			
		}
	}


	
	
	
	

	

}

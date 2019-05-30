package game;

import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {
	private int value = 10;
	
	public OxygenTank() {
		super("Oxygen Tank", '=');
	}

	public int getValue() {
		return value;
	}

	public void decreaseValue() {
		if (!isEmpty()) {
			value--;
		}
	}
	
	public boolean isEmpty() {
		return value <= 0;
	}


	
	
	
	

	

}

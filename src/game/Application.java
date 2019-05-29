package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.DemoSkills;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

/**
 * Class consisting of the main method of the game.
 */
public class Application {

	/**
	 * Initialises all the required classes.
	 * 
	 * @param args argument for the main method
	 */
	public static void main(String[] args) {
		
		World world = new World(new Display());
		
		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new Crater());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		List<String> moonMap = Arrays.asList(
                "ooooooooooooooooo.....o",
                "oooooooo...oooooooooooo",
                "oooooooooo..ooooooooooo",
                "oooooooooo...oooooooooo",
                "ooooooo......oooooooooo",
                "ooooooooo...ooooooooooo",
                "oooooooooo......ooooooo",
                "ooooo...ooooooooooooooo",
                "ooooooooooooooooo.....o",
                "oooo...ooooooooooo...oo",
                "ooooooooooooooooooooooo");
		GameMap moon = new GameMap(groundFactory, moonMap);
		world.addMap(moon);
		
		Location earthRocketLocation = gameMap.at(18, 9);
		Location moonRocketLocation = moon.at(9, 4);
		
		Item rocketToMoon = Item.newFurniture("Rocket", '^');
		rocketToMoon.getAllowableActions().add(new MoveActorAction(moonRocketLocation, "to Moon!"));
		
		Item rocketToEarth = Item.newFurniture("Rocket", '^');
		rocketToEarth.getAllowableActions().add(new MoveActorAction(earthRocketLocation, "to Earth!"));
		
		RocketPad rocketPad = new RocketPad(rocketToMoon);
		gameMap.add(rocketPad, earthRocketLocation);
		
		moon.addItem(rocketToEarth, moonRocketLocation.x(), moonRocketLocation.y());
		
		Actor player = new StunnablePlayer("Player", '@', 1, 100, moon, earthRocketLocation);
		world.addPlayer(player, gameMap, 2, 2);
		
		// testing code
		Item rocketBody = new Item("Rocket Body", '[');
		Item rocketEngine = new Item("Rocket Engine", '*');
		gameMap.addItem(rocketEngine, 2, 3);
		gameMap.addItem(rocketBody, 2, 4);
		
		
		Item spaceSuit = new Item("space suit", '&');
        spaceSuit.addSkill(GameSkills.SPACETRAVELLER);
        gameMap.addItem(spaceSuit, 0, 1);
        
        Item oxygenDispenser = Item.newFurniture("Oxygen Dispenser", 'W');
        oxygenDispenser.getAllowableActions().add(new PressButtonAction(oxygenDispenser));
        gameMap.addItem(oxygenDispenser, 2, 10);
		
		
		// base code
		
//		Grunt grunt = new Grunt("Mongo", player);
//		gameMap.addActor(grunt, 0, 0);
//
//
//		Goon goon = new Goon("Norbert", player);
//		gameMap.addActor(goon, 10, 3);
//
//		Ninja ninja = new Ninja("Naruto", player);
//		gameMap.addActor(ninja, 10, 7);
//
//		
//		 Q q = new Q("Q");
//		gameMap.addActor(q, 17, 6);
//		
//		Item rocketPlan = new Item("Rocket Plan", 'x');
//		gameMap.addItem(rocketPlan, 6, 2);
//		
//
//		Miniboss doctorMaybe = new Miniboss("Docter Maybe");
//		doctorMaybe.addItemToInventory(Item.newInventoryItem("Rocket Engine", '*'));
//		gameMap.addActor(doctorMaybe, 15, 2);
		
		
		world.run();
	}
}

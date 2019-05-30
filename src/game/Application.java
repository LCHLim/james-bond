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
		
		World world = new GameWorld(new Display());
		
		FancyGroundFactory groundFactory = new FancyGroundFactory(
				new Floor(),
				new Wall(),
				new Door(),
				new Crater(),
				new Water()
				);
		
		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				".......~~..............",
				".......~~..............",
				".......................",
				".......................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		List<String> moonMap = Arrays.asList(
                "ooooooooooooooooooooooo",
                "oooooooo...ooooo.....oo",
                "oooooooooo..oooo.....oo",
                "oooooooooo...ooo.....oo",
                "ooooooo......oooooooooo",
                "ooooooooo...ooooooooooo",
                "oooooooooo......ooooooo",
                "ooooo...ooooooooooooooo",
                "ooooooooooooooooo.....o",
                "oooooooooooooooooo...oo",
                "ooooooooooooooooooooooo");
		GameMap moon = new GameMap(groundFactory, moonMap);
		world.addMap(moon);
		
		
		
		// ============ Rocket Location =============
		
		
		Location earthRocketLocation = gameMap.at(18, 9);
		Location moonRocketLocation = moon.at(18, 2);
		
		
		// ================= Player =================
		
		
		Actor player = new StunnablePlayer("Player", '@', 1, 1000, moon, earthRocketLocation);
		world.addPlayer(player, gameMap, 9, 11);
		
		
		// ============= Setup in Earth =============
		
		
		// ------------------ Item ------------------
		
		Item rocketToMoon = Item.newFurniture("Rocket", '^');
		rocketToMoon.getAllowableActions().add(new MoveActorAction(moonRocketLocation, "to Moon!"));
		
		Item rocketPlan = new Item("Rocket Plan", 'x');
		gameMap.addItem(rocketPlan, 6, 2);
		
		Item spaceSuit = new Item("space suit", '&');
		spaceSuit.addSkill(GameSkills.SPACETRAVELLER);
      	gameMap.addItem(spaceSuit, 3, 9);
      	
      	Item oxygenDispenser = Item.newFurniture("Oxygen Dispenser", 'D');
      	oxygenDispenser.getAllowableActions().add(new PressButtonAction(oxygenDispenser));
      	gameMap.addItem(oxygenDispenser, 20, 8);
		
      	// ---------------- Ground ------------------
      	
      	RocketPad rocketPad = new RocketPad(rocketToMoon);
		gameMap.add(rocketPad, earthRocketLocation);
				
		// ----------------- Actor ------------------
		
		Grunt mongo = new Grunt("Mongo", player);
		gameMap.addActor(mongo, 0, 5);

		Goon norbert = new Goon("Norbert", player);
		gameMap.addActor(norbert, 10, 3);

		Ninja naruto = new Ninja("Naruto", player);
		gameMap.addActor(naruto, 6, 6);

		 Q q = new Q("Q");
		gameMap.addActor(q, 17, 6);

		DoctorMaybe doctorMaybe = new DoctorMaybe("Docter Maybe");
		doctorMaybe.addItemToInventory(Item.newInventoryItem("Rocket Engine", '*'));
		gameMap.addActor(doctorMaybe, 15, 2);
	

		// ------------- Setup in Moon --------------
		
		
		// ------------------ Item ------------------
		
		Item rocketToEarth = Item.newFurniture("Rocket", '^');
		rocketToEarth.getAllowableActions().add(new MoveActorAction(earthRocketLocation, "to Earth!"));
		moon.addItem(rocketToEarth, moonRocketLocation.x(), moonRocketLocation.y());
		
		Item exoskeleton = Item.newInventoryItem("Exoskeleton", '`');
        exoskeleton.addSkill(GameSkills.INVULNERABLE);
		
	    Item waterPistol = new Item("Water Pistol", '/');
	    moon.addItem(waterPistol, 18 , 8);
		
	    // ----------------- Actor ------------------
		
		Grunt james = new Grunt("James", player);
		james.addSkill(GameSkills.SPACETRAVELLER);
		moon.addActor(james, 10, 5);

		Goon bruce = new Goon("Bruce", player);
		bruce.addSkill(GameSkills.SPACETRAVELLER);
		moon.addActor(bruce, 8, 4);

        YugoMaxx yugo = new YugoMaxx("Yugo Maxx");
        yugo.addSkill(GameSkills.SPACETRAVELLER);
        yugo.addItemToInventory(exoskeleton);
        moon.addActor(yugo, 5, 2);

        
		// ===========================================

        
        
		world.run();
	}
}

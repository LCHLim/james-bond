package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
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
		/**
		 * Initialisation of the World class with an instance of Display as parameter.
		 */
		World world = new World(new Display());
		
		/**
		 * Initialisation of FancyGroundFactory with instances of Floor, Wall, Door and
		 * RocketPad as parameters.
		 */
		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new RocketPad());
		GameMap gameMap;

		/**
		 * Initialisation of the game map.
		 */
		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				".......................",
				"...........R...........",
				".......................",
				".......................");
		
		/**
		 * Initialisation of GameMap with initialised FancyGroundFactory instance and the map.
		 */
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		/**
		 * Initialisation of StunnablePlayer representing the player and addition of it to world.
		 */
		Actor player = new StunnablePlayer("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		/**
		 * Initialisation of Item representing the key and addition of it to world.
		 */
		Item key = new Item("Key", 'K');
		gameMap.addItem(key, 6, 3);

		/**
		 * Initialisation of Grunt representing the enemy grunt and addition of it to world.
		 */
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);

		/**
		 * Initialisation of Goon representing the enemy goon and addition of it to world.
		 */
		Goon goon = new Goon("Norbert", player);
		gameMap.addActor(goon, 10, 3);

		/**
		 * Initialisation of Ninja representing the enemy ninja and addition of it to world.
		 */
		Ninja ninja = new Ninja("Naruto", player);
		gameMap.addActor(ninja,9 , 3);

		/**
		 * Initialisation of Q representing the non-player character Q and addition of it to world.
		 */
		Q q = new Q("Q");
		gameMap.addActor(q, 17, 6);
		
		/**
		 * Initialisation of Item representing the rocket plan and addition of it to world.
		 */
		Item rocketPlan = new Item("Rocket Plan", 'P');
		gameMap.addItem(rocketPlan, 6, 2);
		
		/**
		 * Initialisation of Miniboss representing the enemy Doctor Maybe and addition of it to world.
		 */
		Miniboss doctorMaybe = new Miniboss("Docter Maybe");
		doctorMaybe.addItemToInventory(Item.newInventoryItem("Rocket Engine", 'E'));
		gameMap.addActor(doctorMaybe, 15, 2);
		
		/**
		 * Run the game.
		 */
		world.run();
	}
}

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

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new RocketPad());
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
				"..................o....",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new StunnablePlayer("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
	
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);

		Goon goon = new Goon("Norbert", player);
		gameMap.addActor(goon, 10, 3);
		
		Ninja ninja = new Ninja("Naruto", player);
		gameMap.addActor(ninja, 10, 7);
		
		Q q = new Q("Q");
		gameMap.addActor(q, 17, 6);
		
		Item rocketPlan = new Item("Rocket Plan", 'x');
		gameMap.addItem(rocketPlan, 6, 2);
		
		Miniboss doctorMaybe = new Miniboss("Docter Maybe");
		doctorMaybe.addItemToInventory(Item.newInventoryItem("Rocket Engine", '*'));
		gameMap.addActor(doctorMaybe, 15, 2);
			
		world.run();
	}
}

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
				"...........R...........",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new StunnablePlayer("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		Item key = new Item("Key", 'K');
		gameMap.addItem(key, 2, 3);
//		Ninja ninja = new Ninja("Naruto", player);
//		gameMap.addActor(ninja, 5, 10);
		
		
//		Grunt grunt = new Grunt("Mongo", player);
//		gameMap.addActor(grunt, 0, 0);
//		Grunt grunt2 = new Grunt("Norbert", player);
//		gameMap.addActor(grunt2,  10, 10);
//		Goon goon = new Goon("MaBoi", player);
//		gameMap.addActor(goon, 10, 3);
		
//		gameMap.at(2, 3).addItem(new Item("Rocket Plan", 'P'));
//		Q q = new Q("Q");
//		gameMap.addActor(q, 2, 8);
		
		
//		Miniboss doctorMaybe = new Miniboss("Docter Maybe");
//		doctorMaybe.addItemToInventory(Item.newInventoryItem("Rocket Engine", 'E'));
//		gameMap.addActor(doctorMaybe, 15, 2);
			
		world.run();
	}
}

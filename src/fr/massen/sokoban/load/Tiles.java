package fr.massen.sokoban.load;

import java.util.Map;

import fr.massen.sokoban.level.tiles.Tile;

public class Tiles {
	
	public static final Tile VOID = new Tile("void");
	public static final Tile FLOOR = new Tile("floor");
	public static final Tile GOAL = new Tile("goal");
	public static final Tile WALL = new Tile("wall") {
		@Override
		public boolean isWall() {
			return true;
		}
	};
	
	private static Map<String, Tile> tileRegistry;
	
	public static void registerTile(Tile tile) {
		tileRegistry.put(tile.getAbsoluteName(), tile);
	}
	
	

}

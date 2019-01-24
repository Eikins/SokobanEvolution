package fr.massen.sokoban.load;

import java.util.Map;

import fr.massen.sokoban.level.tiles.Tile;
import fr.massen.sokoban.physics.AxisAlignedBoundingBox;

public class Tiles {
	
	public static final Tile VOID = new Tile("void");
	public static final Tile FLOOR = new Tile("floor");
	public static final Tile GOAL = new Tile("goal");
	public static final Tile WALL = new Tile("wall") {
		@Override
		public AxisAlignedBoundingBox getCollisionBox() {
			return new AxisAlignedBoundingBox(0f, 0f, 1f, 1f);
		}
	};
	
	private static Map<String, Tile> tileRegistry;
	
	public static void registerTile(Tile tile) {
		tileRegistry.put(tile.getAbsoluteName(), tile);
	}
	
	

}

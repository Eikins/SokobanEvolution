package fr.massen.sokoban.level.tiles;

import fr.massen.sokoban.physics.AxisAlignedBoundingBox;

public class Tile {
	
	private final String tileName;
	
	public Tile(final String tileName) {
		this.tileName = tileName;
	}
	
	public AxisAlignedBoundingBox getCollisionBox() {
		return null;
	}
	
	public String getAbsoluteName() {
		return tileName;
	}
	
	public String getUnlocalizedName() {
		return "tile." + tileName + ".name";
	}
	
	public String toString() {
		return tileName;
	}
	

}

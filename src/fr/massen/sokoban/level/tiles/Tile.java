package fr.massen.sokoban.level.tiles;

public class Tile {
	
	private final String tileName;
	
	public Tile(final String tileName) {
		this.tileName = tileName;
	}
	
	public boolean isWall() {
		return false;
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

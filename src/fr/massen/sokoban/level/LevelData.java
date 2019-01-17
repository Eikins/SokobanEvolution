package fr.massen.sokoban.level;

import java.util.LinkedList;
import java.util.List;

import fr.massen.sokoban.level.tiles.Tile;

public class LevelData {
	
	private final int width, height;
	private final Tile[][] tiles;
	private final List<Entity> entities;
	
	public LevelData(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
		this.entities = new LinkedList<Entity>();
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public boolean setTile(int x, int y, Tile tile) {
		if(tile == null || x >= width || y >= height) {
			return false;
		} else {
			tiles[x][y] = tile;
			return true;
		}
	}
	
	
	
	
}

package fr.massen.sokoban.level;

import java.util.LinkedList;
import java.util.List;

import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.entities.EntityPlayer;
import fr.massen.sokoban.level.tiles.Tile;

public class Level {
	
	public final int width, height;
	private final Tile[][] tiles;
	private final List<Entity> entities;
	
	public Level(int width, int height) {
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

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	public List<Entity> getEntities() {
		return entities;
	}
	
	public EntityPlayer getPlayer() {
		for(Entity e : entities) {
			if(e instanceof EntityPlayer) return (EntityPlayer) e;
		}
		return null;
	}
	
}

package fr.massen.sokoban.level;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.entities.EntityPlayer;
import fr.massen.sokoban.level.tiles.Tile;
import fr.massen.sokoban.maths.Vector2f;
import fr.massen.sokoban.physics.AxisAlignedBoundingBox;
import fr.massen.sokoban.physics.Collider;

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

	public Collection<Collider> checkCollision(AxisAlignedBoundingBox source) {
		Collection<Collider> colliders = new LinkedList<Collider>();
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Tile tile = tiles[x][y];
				AxisAlignedBoundingBox aabb = tile.getCollisionBox();
				if(aabb != null) {
					aabb.offset = new Vector2f(x, y);
					if(aabb.checkCollision(source)) {
						colliders.add(new Collider(tile));
					}
				}
			}
		}
		
		for(Entity entity : entities) {
			AxisAlignedBoundingBox aabb = entity.getHitBox();
			if(aabb != null && aabb != source) {
				if(aabb.checkCollision(source)) {
					colliders.add(new Collider(entity));
				}
			}
		}
		return colliders;
	}
	
}

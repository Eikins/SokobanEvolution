package fr.massen.sokoban.physics;

import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.level.tiles.Tile;

public class Collider {
	
	private Entity sourceEntity;
	private Tile sourceTile;
	
	public Collider(Entity sourceEntity) {
		this.sourceEntity = sourceEntity;
	}
	
	public Collider(Tile sourceTile) {
		this.sourceTile = sourceTile;
	}
	
	public boolean isTile() {
		return sourceTile != null;
	}
	
	public boolean isEntity() {
		return sourceEntity != null;
	}

	public Entity getEntity() {
		return sourceEntity;
	}
	
	public Tile getTile() {
		return sourceTile;
	}
	
	

}

package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.maths.Vector2f;

public class Entity {
	
	protected Level currentLevel;
	protected Vector2f position;
	private Vector2f lastPosition;

	public Entity(Level level) {
		this.position = new Vector2f(0f, 0f);
		this.lastPosition = new Vector2f(0f, 0f);
		this.currentLevel = level;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public Vector2f getLastPosition() {
		return lastPosition;
	}
	
	public void onPhysicsUpdate() {
		lastPosition = position.copy();
	}

}

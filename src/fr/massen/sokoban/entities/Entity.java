package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;

public class Entity {
	
	protected Level currentLevel;
	private float posX, posY;

	public Entity(Level level) {
		this.currentLevel = level;
	}
	
	public void moveTo(float x, float y) {
		posX = x;
		posY = y;
	}
	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}

}

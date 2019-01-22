package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;

public class Entity {
	
	protected Level currentLevel;
	protected float posX, posY;
	private float lastPosX, lastPosY;

	public Entity(Level level) {
		this.currentLevel = level;
	}
	
	public void moveTo(float x, float y) {
		lastPosX = posX;
		lastPosY = posY;
		posX = x;
		posY = y;
	}
	
	public void setPosition(float x, float y) {
		this.posX = x;
		this.posY = y;
		this.lastPosX = x;
		this.lastPosY = y;
	}
	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}
	
	public float getLastPosX() {
		return lastPosX;
	}
	
	public float getLastPosY() {
		return lastPosY;
	}
	
	public void onPhysicsUpdate() {
		lastPosX = posX;
		lastPosY = posY;
	}

}

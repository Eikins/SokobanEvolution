package fr.massen.sokoban.level;

public class Entity {
	
	private float posX, posY;

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

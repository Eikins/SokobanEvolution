package fr.massen.sokoban.physics;

import fr.massen.sokoban.maths.Vector2f;

public class AxisAlignedBoundingBox {
	
	public Vector2f from, to;
	
	public AxisAlignedBoundingBox(float fromX, float fromY, float toX, float toY) {
		from = new Vector2f(fromX, fromY);
		to = new Vector2f(toX, toY);
	}
	
	
	public boolean checkCollision(float x, float y) {
		return true;
	}

}

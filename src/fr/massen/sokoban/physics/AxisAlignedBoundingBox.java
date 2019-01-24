package fr.massen.sokoban.physics;

import fr.massen.sokoban.maths.Vector2f;

public class AxisAlignedBoundingBox {
	
	private Vector2f from, to;
	public Vector2f offset;
	
	public AxisAlignedBoundingBox(float fromX, float fromY, float toX, float toY) {
		from = new Vector2f(fromX, fromY);
		to = new Vector2f(toX, toY);
		offset = new Vector2f(0, 0);
	}
	
	public Vector2f getLowLeftCorner() {
		return new Vector2f(from.x + offset.x, from.y + offset.y);
	}
	
	public Vector2f getUpRightCorner() {
		return new Vector2f(to.x + offset.x, to.y + offset.y);
	}
	
	public Vector2f getLowRightCorner() {
		return new Vector2f(to.x + offset.x, from.y + offset.y);
	}
	
	public Vector2f getUpLeftCorner() {
		return new Vector2f(from.x + offset.x, to.y + offset.y);
	}
	

	
	public AxisAlignedBoundingBox copy() {
		return new AxisAlignedBoundingBox(from.x, from.y, to.x, to.y);
	}
 	
	public boolean checkCollision(Vector2f position) {
		boolean xInside = position.x >= offset.x + from.x && position.x <= offset.x + to.x;
		boolean yInside = position.y >= offset.y + from.y && position.y <= offset.y + to.y;
				
		return xInside && yInside;
	}
	
	public boolean checkCollision(AxisAlignedBoundingBox other) {
		Vector2f lowLeftCorner = other.getLowLeftCorner();
		Vector2f upRightCorner = other.getUpRightCorner();
		Vector2f lowRightCorner = other.getLowRightCorner();
		Vector2f upLeftCorner = other.getUpLeftCorner();
		
		// Check for each corners if they are inside.
		// Be careful, doesn't check if this is INSIDE other
		return checkCollision(lowLeftCorner)
				|| checkCollision(upRightCorner)
				|| checkCollision(lowRightCorner)
				|| checkCollision(upLeftCorner);
	}

}

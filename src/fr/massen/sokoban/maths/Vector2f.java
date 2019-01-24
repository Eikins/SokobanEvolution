package fr.massen.sokoban.maths;

public class Vector2f {
	
	public float x, y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y);
	}
	
	public Vector2f normalize() {
		float magnitude = magnitude();
		return magnitude == 0f ? this : new Vector2f(x / magnitude, y / magnitude);
	}
	
	public Vector2f scale(float scale) {
		return new Vector2f(x * scale, y * scale);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " +  y + ")";
	}

	public Vector2f copy() {
		return new Vector2f(x, y);
	}

}

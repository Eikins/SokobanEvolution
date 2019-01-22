package fr.massen.sokoban.client.render;

import fr.massen.sokoban.level.Level;
import javafx.scene.canvas.GraphicsContext;

public class RenderContext {
	
	private GraphicsContext graphicsContext;
	private Level level;
	
	private long lastNanoTime;
	private float deltaTime;
	
	public RenderContext(GraphicsContext gc, Level level) {
		this.graphicsContext = gc;
		this.level = level;
	}
	
	public GraphicsContext getGraphics() {
		return graphicsContext;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public float getDeltaTime() {
		return deltaTime;
	}

	public void updateDeltaTime(long currentNanoTime) {
		deltaTime = ((float)currentNanoTime - (float)lastNanoTime) / 1000000000.0F;
		lastNanoTime = currentNanoTime;
	}

}

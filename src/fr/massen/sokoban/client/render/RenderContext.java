package fr.massen.sokoban.client.render;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.physics.PhysicsManager;
import javafx.scene.canvas.GraphicsContext;

public class RenderContext {
	
	private GraphicsContext graphicsContext;
	private Level level;
	
	private long lastNanoTime;
	private float deltaTime;
	private float partialTime;
	
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
	
	/**
	 * The delta time is the time elapsed during 2 render frames in seconds.
	 * @return
	 */
	public float getDeltaTime() {
		return deltaTime;
	}
	
	/**
	 * The partial time is the progress between 2 physics updates.
	 * The value goes from 0.0 to 1.0
	 * @return
	 */
	public float getPartialTime() {
		return partialTime;
	}

	public void updateDeltaTime(long currentNanoTime) {
		deltaTime = (float)((double)(currentNanoTime - lastNanoTime) / 1000000000.0D);
		lastNanoTime = currentNanoTime;
	}

	public void updatePartialTime(long currentNanoTime, long lastUpdateNanoTime) {
		double updateDuration = 1000000000.0D / PhysicsManager.PHYSICS_UPDATE_RATE;
		partialTime = (float)((double)(currentNanoTime - lastUpdateNanoTime) / updateDuration);
	}

}

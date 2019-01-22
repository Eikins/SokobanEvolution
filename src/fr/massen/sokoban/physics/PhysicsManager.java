package fr.massen.sokoban.physics;

import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.level.Level;

public class PhysicsManager implements Runnable {

	public static final int PHYSICS_UPDATE_RATE = 20;
	
	private Level currentLevel;
	private long lastUpdateNanoTime;
	
	public PhysicsManager() {
		lastUpdateNanoTime = System.nanoTime();
	}
	
	public void setLevel(Level level) {
		currentLevel = level;
	}
	
	public Level getCurrentLevel(Level level) {
		return currentLevel;
	}
	
	public long getLastUpdateNanoTime() {
		return lastUpdateNanoTime;
	}
	
	@Override
	public void run() {
		if(currentLevel != null && !currentLevel.getEntities().isEmpty()) {
			for(Entity e : currentLevel.getEntities()) {
				e.onPhysicsUpdate();
			}
			/*
			Entity testEntity = currentLevel.getEntities().get(0);
			if(testEntity.getPosX() < 10) {
				testEntity.moveTo(testEntity.getPosX() + 0.05f, testEntity.getPosY());
			}*/

		}
		lastUpdateNanoTime = System.nanoTime();
	}

}

package fr.massen.sokoban.physics;

import fr.massen.sokoban.level.Level;

public class PhysicsManager implements Runnable {

	private Level currentLevel;
	
	public PhysicsManager() {
		
	}
	
	public void setLevel(Level level) {
		currentLevel = level;
	}
	
	public Level getCurrentLevel(Level level) {
		return currentLevel;
	}
	
	@Override
	public void run() {
		
	}

}

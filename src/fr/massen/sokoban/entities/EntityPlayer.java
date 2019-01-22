package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.physics.PhysicsManager;

public class EntityPlayer extends Entity {

	private float velocityX, velocityY;
	
	public EntityPlayer(Level level) {
		super(level);
	}
	
	@Override
	public void onPhysicsUpdate() {
		super.onPhysicsUpdate();
		posX += velocityX / PhysicsManager.PHYSICS_UPDATE_RATE;
		posY += velocityY / PhysicsManager.PHYSICS_UPDATE_RATE;
		
		
		
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}
	
	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}

}

package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.maths.Vector2f;
import fr.massen.sokoban.physics.PhysicsManager;

public class EntityPlayer extends Entity {

	private Vector2f velocity;
	
	public EntityPlayer(Level level) {
		super(level);
		velocity = new Vector2f(0, 0);
	}
	
	@Override
	public void onPhysicsUpdate() {
		super.onPhysicsUpdate();
		position.x += velocity.x / PhysicsManager.PHYSICS_UPDATE_RATE;
		position.y += velocity.y / PhysicsManager.PHYSICS_UPDATE_RATE;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

}

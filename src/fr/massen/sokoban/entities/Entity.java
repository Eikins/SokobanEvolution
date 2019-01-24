package fr.massen.sokoban.entities;

import java.util.Collection;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.maths.Vector2f;
import fr.massen.sokoban.physics.AxisAlignedBoundingBox;
import fr.massen.sokoban.physics.Collider;
import fr.massen.sokoban.physics.PhysicsManager;

public class Entity {
	
	protected Level currentLevel;
	protected Vector2f position;
	private Vector2f lastPosition;
	protected AxisAlignedBoundingBox hitBox;
	
	protected Vector2f velocity;
	

	public Entity(Level level) {
		this.position = new Vector2f(0f, 0f);
		this.lastPosition = new Vector2f(0f, 0f);
		this.currentLevel = level;
		this.velocity = new Vector2f(0, 0);
	}
	
	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
	public AxisAlignedBoundingBox getHitBox() {
		return hitBox;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public Vector2f getLastPosition() {
		return lastPosition;
	}
	
	public void onPhysicsUpdate() {
		lastPosition = position.copy();
		
		position.x += velocity.x / PhysicsManager.PHYSICS_UPDATE_RATE;
		position.y += velocity.y / PhysicsManager.PHYSICS_UPDATE_RATE;
		
		if(hitBox != null) {
			hitBox.offset = position;
			Collection<Collider> colliders = currentLevel.checkCollision(hitBox);
			for(Collider c : colliders) {
				onCollision(c);
				Entity e = c.getEntity();
				if(e != null) {
					// If it is an entity
					c.getEntity().onCollision(new Collider(this));
				}
			}
				
		}
	}
	
	public void onCollision(Collider collider) {
		if(collider.isTile()) {
			position = lastPosition;
			hitBox.offset = position;
		}
	}

}

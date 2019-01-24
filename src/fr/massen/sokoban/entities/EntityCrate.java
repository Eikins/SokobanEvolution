package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.physics.AxisAlignedBoundingBox;
import fr.massen.sokoban.physics.Collider;

public class EntityCrate extends Entity {

	public EntityCrate(Level level) {
		super(level);
		hitBox = new AxisAlignedBoundingBox(-0.48f, -0.48f, 0.48f, 0.48f);
	}
	
	@Override
	public void onCollision(Collider collider) {
		super.onCollision(collider);
		Entity e = collider.getEntity();
		if(e != null) {
			if(e instanceof EntityPlayer) {
				velocity = e.velocity.normalize().scale(10f);
				e.position = e.getLastPosition();
				e.getHitBox().offset = e.getLastPosition();
			} else if (e instanceof EntityCrate) {
				position = getLastPosition();
				hitBox.offset = position;
			}
		}
		
	}
	
	@Override
	public void onPhysicsUpdate() {
		super.onPhysicsUpdate();
		velocity = velocity.scale(0.5f);
	}

}

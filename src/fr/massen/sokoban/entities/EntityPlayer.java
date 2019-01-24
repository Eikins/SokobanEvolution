package fr.massen.sokoban.entities;

import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.physics.AxisAlignedBoundingBox;

public class EntityPlayer extends Entity {

	public EntityPlayer(Level level) {
		super(level);
		hitBox = new AxisAlignedBoundingBox(-0.3f, -0.3f, 0.3f, 0.3f);
	}

}

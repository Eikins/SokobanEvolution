package fr.massen.sokoban.client.render.entities;

import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.entities.EntityCrate;
import javafx.scene.paint.Color;

public class RenderEntityCrate implements IEntityRenderer<EntityCrate> {

	@Override
	public void render(EntityCrate entity, RenderContext context) {
		context.getGraphics().setFill(Color.BLUE);
		context.getGraphics().fillRect(entity.getPosX(), entity.getPosY(), 64, 64);
	}
	
}

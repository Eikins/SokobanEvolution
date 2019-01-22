package fr.massen.sokoban.client.render.entities;

import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.entities.Entity;
import javafx.scene.image.Image;

public class RenderEntityBasic implements IEntityRenderer<Entity> {

	private Image image;

	public RenderEntityBasic (String entityName) {
		image = new Image("file:assets/textures/entities/" + entityName + "/" + entityName + ".png");
	}
	
	@Override
	public void render(Entity entity, RenderContext context) {
		float x = entity.getLastPosX() + (entity.getPosX() - entity.getLastPosX()) * context.getPartialTime();
		float y = entity.getLastPosY() + (entity.getPosY() - entity.getLastPosY()) * context.getPartialTime();
		context.getGraphics().drawImage(image, x * 64, y * 64, 64, 64);
	}
	
}

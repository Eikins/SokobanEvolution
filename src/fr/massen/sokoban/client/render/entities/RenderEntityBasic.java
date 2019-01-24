package fr.massen.sokoban.client.render.entities;

import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.maths.Vector2f;
import javafx.scene.image.Image;

public class RenderEntityBasic implements IEntityRenderer<Entity> {

	private Image image;

	public RenderEntityBasic (String entityName) {
		image = new Image("file:assets/textures/entities/" + entityName + "/" + entityName + ".png");
	}
	
	@Override
	public void render(Entity entity, RenderContext context) {
		Vector2f lastPosition = entity.getLastPosition();
		Vector2f position = entity.getPosition();
		float x = lastPosition.x + (position.x - lastPosition.x) * context.getPartialTime();
		float y = lastPosition.y + (position.y - lastPosition.y) * context.getPartialTime();
		
		context.getGraphics().drawImage(image, (x - 0.5f) * 64, (y - 0.5f) * 64, 64, 64);
	}
	
}

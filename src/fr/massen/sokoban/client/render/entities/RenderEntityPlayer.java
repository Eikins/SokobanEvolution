package fr.massen.sokoban.client.render.entities;

import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.entities.EntityPlayer;
import fr.massen.sokoban.maths.Vector2f;
import javafx.scene.image.Image;

public class RenderEntityPlayer implements IEntityRenderer<EntityPlayer> {

	private Image image;

	public RenderEntityPlayer() {
		image = new Image("file:assets/textures/entities/player/player_23.png");
	}
	
	@Override
	public void render(EntityPlayer entity, RenderContext context) {
		Vector2f lastPosition = entity.getLastPosition();
		Vector2f position = entity.getPosition();
		float x = lastPosition.x + (position.x - lastPosition.x) * context.getPartialTime();
		float y = lastPosition.y + (position.y - lastPosition.y) * context.getPartialTime();
		
		context.getGraphics().drawImage(image, x * 64, y * 64, 64, 64);
	}
	
}

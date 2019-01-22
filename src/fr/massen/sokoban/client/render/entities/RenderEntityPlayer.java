package fr.massen.sokoban.client.render.entities;

import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.entities.EntityPlayer;
import javafx.scene.image.Image;

public class RenderEntityPlayer implements IEntityRenderer<EntityPlayer> {

	private Image image;

	public RenderEntityPlayer() {
		image = new Image("file:assets/textures/entities/player/player_23.png");
	}
	
	@Override
	public void render(EntityPlayer entity, RenderContext context) {
		float x = entity.getLastPosX() + (entity.getPosX() - entity.getLastPosX()) * context.getPartialTime();
		float y = entity.getLastPosY() + (entity.getPosY() - entity.getLastPosY()) * context.getPartialTime();
		context.getGraphics().drawImage(image, x * 64, y * 64, 64, 64);
	}
	
}

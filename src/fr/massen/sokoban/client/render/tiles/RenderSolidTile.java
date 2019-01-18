package fr.massen.sokoban.client.render.tiles;

import javafx.scene.image.Image;

public class RenderSolidTile implements ITileRenderer {
	
	private final Image image;
	
	public RenderSolidTile(final String textureName) {
		image = new Image("assets/textures/tiles/" + textureName + ".png");
	}

	@Override
	public Image getImage(float deltaTime) {
		return image;
	}

}

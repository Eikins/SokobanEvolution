package fr.massen.sokoban.client.render.tiles;

import fr.massen.sokoban.level.tiles.Tile;
import javafx.scene.image.Image;

public class RenderSolidTile implements ITileRenderer {
	
	private final Image image;
	
	public RenderSolidTile(final Tile tile) {
		this(tile.getAbsoluteName());
	}
	public RenderSolidTile(final String textureName) {
		image = new Image("file:assets/textures/tiles/" + textureName + ".png");
	}

	@Override
	public Image getImage(float deltaTime) {
		return image;
	}

}

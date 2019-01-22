package fr.massen.sokoban.client.render.tiles;

import fr.massen.sokoban.client.render.RenderContext;
import javafx.scene.image.Image;

public interface ITileRenderer {
	
	Image getImage(RenderContext context);

}

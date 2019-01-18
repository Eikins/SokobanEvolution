package fr.massen.sokoban.client.render;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderer {
	
	void render(GraphicsContext gc, float deltaTime);

}

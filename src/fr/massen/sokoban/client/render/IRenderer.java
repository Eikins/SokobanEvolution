package fr.massen.sokoban.client.render;

public interface IRenderer {
	
	void render(RenderContext render);
	
	int getRenderLayer();

}

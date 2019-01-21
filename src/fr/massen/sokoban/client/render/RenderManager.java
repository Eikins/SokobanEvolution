package fr.massen.sokoban.client.render;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class RenderManager extends AnimationTimer {

	private long lastNanoTime;
	private float deltaTime;
	
	private GraphicsContext graphicsContext;
	List<IRenderer> renderers;
	
	
	public RenderManager(Canvas canvas) {
		this.renderers = new LinkedList<IRenderer>();
		this.graphicsContext = canvas.getGraphicsContext2D();
	}

	public void registerRenderer(IRenderer renderer) {
		renderers.add(renderer);
		
		// When register a IRenderer, sort the list by render layout
		renderers.sort(new Comparator<IRenderer>() {

			@Override
			public int compare(IRenderer r1, IRenderer r2) {
				if(r1.getRenderLayer() == r2.getRenderLayer()) {
					return 0;
				} else {
					return r1.getRenderLayer() > r2.getRenderLayer() ? 1 : -1;
				}
			}
			
		});
	}
	
	@Override
	public void handle(long currentNanoTime) {
		deltaTime = ((float)currentNanoTime - (float)lastNanoTime) / 1000000000.0F;
		lastNanoTime = currentNanoTime;
		
		// Do Renders
		for(IRenderer renderer : renderers) {
			renderer.render(graphicsContext, deltaTime);
		}
	}
	
}

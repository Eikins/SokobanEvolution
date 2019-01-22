package fr.massen.sokoban.client.render;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import fr.massen.sokoban.SokobanApplication;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

public class RenderManager extends AnimationTimer {

	private final SokobanApplication application;
	
	private RenderContext renderContext;
	List<IRenderer> renderers;
	
	
	public RenderManager(SokobanApplication application, Canvas canvas) {
		this.renderers = new LinkedList<IRenderer>();
		renderContext = new RenderContext(canvas.getGraphicsContext2D(), null);
		this.application = application;
	}
	
	public RenderContext getRenderContext() {
		return renderContext;
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
		renderContext.updateDeltaTime(currentNanoTime);
		renderContext.updatePartialTime(currentNanoTime, application.getPhysicsManager().getLastUpdateNanoTime());
		// Do Renders
		for(IRenderer renderer : renderers) {
			renderer.render(renderContext);
		}
	}
	
}

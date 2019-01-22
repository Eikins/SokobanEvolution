package fr.massen.sokoban.client.render.entities;

import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.entities.Entity;

public interface IEntityRenderer<T extends Entity> {
	
	void render(T entity, RenderContext context);

}

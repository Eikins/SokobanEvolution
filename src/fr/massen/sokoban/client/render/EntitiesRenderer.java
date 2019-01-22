package fr.massen.sokoban.client.render;

import java.util.HashMap;
import java.util.Map;

import fr.massen.sokoban.client.render.entities.IEntityRenderer;
import fr.massen.sokoban.client.render.entities.RenderEntityBasic;
import fr.massen.sokoban.client.render.entities.RenderEntityPlayer;
import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.entities.EntityCrate;
import fr.massen.sokoban.entities.EntityPlayer;
import fr.massen.sokoban.level.Level;

public class EntitiesRenderer implements IRenderer {

	private final Map<Class<? extends Entity>, IEntityRenderer<? extends Entity>> entitiesRenderers;

	public EntitiesRenderer() {
		entitiesRenderers = new HashMap<Class<? extends Entity>, IEntityRenderer<? extends Entity>>();
		registerEntityRenderer(EntityCrate.class, new RenderEntityBasic("crate"));
		registerEntityRenderer(EntityPlayer.class, new RenderEntityPlayer());
	}

	public <T extends Entity> void registerEntityRenderer(Class<T> entityClass, IEntityRenderer<? super T> renderer) {
		entitiesRenderers.put(entityClass, renderer);
	}
	
	@SuppressWarnings("unchecked")
	// We know it's safe
	private <T extends Entity> void renderEntity(T entity, RenderContext ctx) {
		IEntityRenderer<? super T> entityRenderer = (IEntityRenderer<? super T>) entitiesRenderers.get(entity.getClass());
		if(entityRenderer != null) {
			entityRenderer.render(entity, ctx);
		}
	}

	@Override
	public void render(RenderContext render) {
		Level level = render.getLevel();
		if(level != null) {
			for(Entity e : level.getEntities()) {
				renderEntity(e, render);
			}
		}
	}

	@Override
	public int getRenderLayer() {
		return 0;
	}


}

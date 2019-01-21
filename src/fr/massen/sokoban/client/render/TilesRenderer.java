package fr.massen.sokoban.client.render;

import java.util.HashMap;
import java.util.Map;

import fr.massen.sokoban.client.render.tiles.ITileRenderer;
import fr.massen.sokoban.client.render.tiles.RenderSolidTile;
import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.level.tiles.Tile;
import fr.massen.sokoban.load.Tiles;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TilesRenderer implements IRenderer {

	private final Map<Tile, ITileRenderer> tileRenderers;
	private Level currentLevel;

	public TilesRenderer() {
		tileRenderers = new HashMap<Tile, ITileRenderer>();

		registerTileRenderer(Tiles.FLOOR, new RenderSolidTile("ground_01"));
		registerTileRenderer(Tiles.VOID, new RenderSolidTile("ground_01"));
		registerTileRenderer(Tiles.WALL, new RenderSolidTile("bricks_01"));
		registerTileRenderer(Tiles.GOAL, new RenderSolidTile("ground_02"));
	}

	public void registerTileRenderer(Tile tile, ITileRenderer renderer) {
		tileRenderers.put(tile, renderer);
	}

	public void setLevel(Level level) {
		this.currentLevel = level;
	}

	@Override
	public void render(GraphicsContext gc, float deltaTime) {
		if(currentLevel != null) {
			for(int x = 0; x < currentLevel.width; x++) {
				for(int y = 0; y < currentLevel.height; y++) {
					Tile tile = currentLevel.getTile(x, y);
					ITileRenderer tileRenderer = tileRenderers.get(tile);
					if(tileRenderer != null) {
						Image img = tileRenderer.getImage(deltaTime);
						gc.drawImage(img, x * 64, y * 64, 64, 64);
					}
				}
			}
		}
	}

	@Override
	public int getRenderLayer() {
		return 0;
	}



}

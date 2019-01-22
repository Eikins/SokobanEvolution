package fr.massen.sokoban.client.render;

import java.util.HashMap;
import java.util.Map;

import fr.massen.sokoban.client.render.tiles.ITileRenderer;
import fr.massen.sokoban.client.render.tiles.RenderSolidTile;
import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.level.tiles.Tile;
import fr.massen.sokoban.load.Tiles;
import javafx.scene.image.Image;

public class TilesRenderer implements IRenderer {

	private final Map<Tile, ITileRenderer> tileRenderers;

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

	@Override
	public void render(RenderContext render) {
		Level level = render.getLevel();
		if(level != null) {
			for(int x = 0; x < level.width; x++) {
				for(int y = 0; y < level.height; y++) {
					Tile tile = level.getTile(x, y);
					ITileRenderer tileRenderer = tileRenderers.get(tile);
					if(tileRenderer != null) {
						Image img = tileRenderer.getImage(render);
						render.getGraphics().drawImage(img, x * 64, y * 64, 64, 64);
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

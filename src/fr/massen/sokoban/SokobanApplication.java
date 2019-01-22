package fr.massen.sokoban;

import java.io.File;
import java.util.List;

import fr.massen.sokoban.client.render.EntitiesRenderer;
import fr.massen.sokoban.client.render.IRenderer;
import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.client.render.RenderManager;
import fr.massen.sokoban.client.render.TilesRenderer;
import fr.massen.sokoban.entities.EntityCrate;
import fr.massen.sokoban.io.ILevelReader;
import fr.massen.sokoban.io.ReadLevelException;
import fr.massen.sokoban.io.SokReader;
import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.physics.PhysicsManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SokobanApplication extends Application {

	public static final int WINDOW_WIDTH = 1216;
	public static final int WINDOW_HEIGHT = 704;

	private RenderManager renderManager;
	private PhysicsManager physicsManager;
	private Level currentLevel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SokobanEvolution");
		primaryStage.setResizable(false);
		Group root = new Group();
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		primaryStage.setScene(scene);

		Canvas renderCanvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		renderManager = new RenderManager(this, renderCanvas);
		root.getChildren().add(renderCanvas);

		IRenderer backgroundRenderer = new IRenderer() {

			@Override
			public void render(RenderContext render) {
				render.getGraphics().setFill(Color.web("#AC753B"));
				render.getGraphics().fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			}

			@Override
			public int getRenderLayer() {
				return -1;
			}
			
		};

		renderManager.registerRenderer(backgroundRenderer);
		
		renderManager.start();

		TilesRenderer tilesRenderer = new TilesRenderer();
		EntitiesRenderer entitiesRenderer = new EntitiesRenderer();
		
		// BEGIN TEST
		File levelFile = new File("assets/levels/levels.sok");
		ILevelReader levelReader = new SokReader();
		try {
			List<Level> levels = levelReader.readLevels(levelFile);
			currentLevel = levels.get(0);
			EntityCrate crate = new EntityCrate(currentLevel);
			crate.moveTo(128, 256);
			currentLevel.getEntities().add(crate);
			renderManager.getRenderContext().setLevel(currentLevel);
			renderManager.registerRenderer(tilesRenderer);
			renderManager.registerRenderer(entitiesRenderer);
		} catch (ReadLevelException e) {
			e.printStackTrace();
		}

		primaryStage.show();
	}

	public RenderManager getRenderManager() {
		return renderManager;
	}
	
	public PhysicsManager getPhysicsManager() {
		return physicsManager;
	}

}

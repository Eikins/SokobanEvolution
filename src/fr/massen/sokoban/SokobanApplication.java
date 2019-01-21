package fr.massen.sokoban;

import java.io.File;
import java.util.List;

import fr.massen.sokoban.client.render.IRenderer;
import fr.massen.sokoban.client.render.RenderManager;
import fr.massen.sokoban.client.render.TilesRenderer;
import fr.massen.sokoban.io.ILevelReader;
import fr.massen.sokoban.io.ReadLevelException;
import fr.massen.sokoban.io.SokReader;
import fr.massen.sokoban.level.Level;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SokobanApplication extends Application {

	public static final int WINDOW_WIDTH = 1216;
	public static final int WINDOW_HEIGHT = 704;

	private RenderManager renderManager;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SokobanEvolution");
		primaryStage.setResizable(false);
		Group root = new Group();
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		primaryStage.setScene(scene);

		Canvas renderCanvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		renderManager = new RenderManager(renderCanvas);
		root.getChildren().add(renderCanvas);

		IRenderer backgroundRenderer = new IRenderer() {

			@Override
			public void render(GraphicsContext gc, float deltaTime) {
				gc.setFill(Color.web("#AC753B"));
				gc.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			}

			@Override
			public int getRenderLayer() {
				return -1;
			}
			
		};

		renderManager.registerRenderer(backgroundRenderer);
		
		renderManager.start();

		TilesRenderer tilesRenderer = new TilesRenderer();
		
		// BEGIN TEST
		File levelFile = new File("assets/levels/levels.sok");
		ILevelReader levelReader = new SokReader();
		try {
			List<Level> levels = levelReader.readLevels(levelFile);
			tilesRenderer.setLevel(levels.get(0));
			renderManager.registerRenderer(tilesRenderer);
		} catch (ReadLevelException e) {
			e.printStackTrace();
		}

		primaryStage.show();
	}

	public RenderManager getRenderManager() {
		return renderManager;
	}

}

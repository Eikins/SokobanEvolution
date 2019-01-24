package fr.massen.sokoban;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.massen.sokoban.client.render.EntitiesRenderer;
import fr.massen.sokoban.client.render.IRenderer;
import fr.massen.sokoban.client.render.RenderContext;
import fr.massen.sokoban.client.render.RenderManager;
import fr.massen.sokoban.client.render.TilesRenderer;
import fr.massen.sokoban.controller.Controller;
import fr.massen.sokoban.controller.PlayerController;
import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.io.ILevelReader;
import fr.massen.sokoban.io.ReadLevelException;
import fr.massen.sokoban.io.SokReader;
import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.level.tiles.Tile;
import fr.massen.sokoban.maths.Vector2f;
import fr.massen.sokoban.physics.AxisAlignedBoundingBox;
import fr.massen.sokoban.physics.PhysicsManager;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
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

		startPhysicsThread();
		startRenderThread(root);
		



	
		// BEGIN TEST
		File levelFile = new File("assets/levels/levels.sok");
		ILevelReader levelReader = new SokReader();
		try {
			List<Level> levels = levelReader.readLevels(levelFile);
			Random random = new Random();
			currentLevel = levels.get(random.nextInt(levels.size()));
			renderManager.getRenderContext().setLevel(currentLevel);
			physicsManager.setLevel(currentLevel);
			
			
			Controller controller = new PlayerController(currentLevel.getPlayer());
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					controller.onKeyPressed(event.getCode());
				}
				
			});
			
			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					controller.onKeyReleased(event.getCode());
				}
				
			});

		} catch (ReadLevelException e) {
			e.printStackTrace();
		}

		primaryStage.show();
	}

	private void startPhysicsThread() {
		physicsManager = new PhysicsManager();
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(physicsManager, 0, 1000 / PhysicsManager.PHYSICS_UPDATE_RATE, TimeUnit.MILLISECONDS);
	}

	private void startRenderThread(Group root) {
		Canvas renderCanvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		TilesRenderer tilesRenderer = new TilesRenderer();
		EntitiesRenderer entitiesRenderer = new EntitiesRenderer();
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
		
		IRenderer hitBoxRenderer = new IRenderer() {

			@Override
			public void render(RenderContext render) {
				GraphicsContext graphics = render.getGraphics();
				Level level = render.getLevel();
				if(level == null) return;
				
				graphics.setStroke(Color.AQUA);
				
				for(int x = 0; x < level.width; x++) {
					for(int y = 0; y < level.height; y++) {
						Tile tile = level.getTile(x, y);
						AxisAlignedBoundingBox aabb = tile.getCollisionBox();
						if(tile.getCollisionBox() != null) {
							aabb.offset = new Vector2f(x, y);
							Vector2f from = aabb.getLowLeftCorner();
							Vector2f to = aabb.getUpRightCorner();
							float width = to.x - from.x;
							float height = to.y - from.y;
							graphics.strokeRect(from.x * 64, from.y * 64, width * 64, height * 64);
						}
					}
				}
				
				for(Entity entity : level.getEntities()) {
					if(entity.getHitBox() != null) {
						Vector2f from = entity.getHitBox().getLowLeftCorner();
						Vector2f to = entity.getHitBox().getUpRightCorner();
						float width = to.x - from.x;
						float height = to.y - from.y;
						graphics.strokeRect(from.x * 64, from.y * 64, width * 64, height * 64);
					}
				}
			}

			@Override
			public int getRenderLayer() {
				return 10;
			}
			
		};
		
		root.getChildren().add(renderCanvas);
		renderManager = new RenderManager(this, renderCanvas);
		renderManager.registerRenderer(backgroundRenderer);
		renderManager.registerRenderer(tilesRenderer);
		renderManager.registerRenderer(entitiesRenderer);
		// DEBUG PURPOSE
		 renderManager.registerRenderer(hitBoxRenderer);
		renderManager.start();
	}

	public RenderManager getRenderManager() {
		return renderManager;
	}
	
	public PhysicsManager getPhysicsManager() {
		return physicsManager;
	}

}

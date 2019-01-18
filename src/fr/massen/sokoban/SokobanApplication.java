package fr.massen.sokoban;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SokobanApplication extends Application {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SokobanEvolution");
		primaryStage.setResizable(false);
		Group root = new Group();
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
		root.getChildren().
	}

}

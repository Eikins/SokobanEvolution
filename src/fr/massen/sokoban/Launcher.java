package fr.massen.sokoban;

import fr.massen.sokoban.io.SokReader;
import fr.massen.sokoban.load.Tiles;
import javafx.application.Application;

public class Launcher {
	
	public static void main(String[] args) {
		SokReader.addTileCode('#', Tiles.WALL);
		SokReader.addTileCode(' ', Tiles.FLOOR);
		SokReader.addTileCode('.', Tiles.GOAL);
		
		SokReader.addTileCode('@', Tiles.FLOOR);
		SokReader.addTileCode('+', Tiles.FLOOR);
		SokReader.addTileCode('$', Tiles.FLOOR);
		SokReader.addTileCode('*', Tiles.FLOOR);
		
		Application.launch(SokobanApplication.class, args);

	}

}

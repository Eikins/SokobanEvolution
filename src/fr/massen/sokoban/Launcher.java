package fr.massen.sokoban;

import javafx.application.Application;

public class Launcher {
	
	public static void main(String[] args) {
		Application.launch(SokobanApplication.class, args);
		/*SokReader.addTileCode('#', Tiles.WALL);
		SokReader.addTileCode(' ', Tiles.FLOOR);
		SokReader.addTileCode('.', Tiles.GOAL);
		
		SokReader.addTileCode('@', Tiles.FLOOR);
		SokReader.addTileCode('+', Tiles.FLOOR);
		SokReader.addTileCode('$', Tiles.FLOOR);
		SokReader.addTileCode('*', Tiles.FLOOR);
		
		
		
		File levelFile = new File("assets/levels/levels.sok");
		ILevelReader levelReader = new SokReader();
		try {
			List<Level> levels = levelReader.readLevels(levelFile);
			System.out.println(levels.get(0).toString());
		} catch (ReadLevelException e) {
			e.printStackTrace();
		}*/
		
	}

}

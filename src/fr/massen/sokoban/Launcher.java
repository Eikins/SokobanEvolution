package fr.massen.sokoban;

import java.io.File;
import java.util.List;

import fr.massen.sokoban.io.ILevelReader;
import fr.massen.sokoban.io.ReadLevelException;
import fr.massen.sokoban.io.SokReader;
import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.load.Tiles;

public class Launcher {
	
	public static void main(String[] args) {
		SokReader.addTileCode('#', Tiles.WALL);
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
		}
		
	}

}

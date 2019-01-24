package fr.massen.sokoban.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.massen.sokoban.entities.Entity;
import fr.massen.sokoban.level.Level;
import fr.massen.sokoban.level.tiles.Tile;
import fr.massen.sokoban.load.Tiles;
import fr.massen.sokoban.maths.Vector2f;

public class SokReader implements ILevelReader {

	private static final Map<Character, Tile> tileCodes = new HashMap<Character, Tile>();
	private static final Map<Character, Class<? extends Entity>> entityCodes = new HashMap<Character, Class<? extends Entity>>();

	public static void addTileCode(char tileCode, Tile tile) {
		tileCodes.put(tileCode, tile);
	}

	public static void addEntityCode(char entityCode, Class<? extends Entity> entityClass) {
		entityCodes.put(entityCode, entityClass);
	}
	
	@Override
	public List<Level> readLevels(File file) throws ReadLevelException {
		List<Level> levels = new ArrayList<Level>();
		try {
			Scanner scanner = new Scanner(file);
			Level level;
			while ((level = readNextLevel(scanner)) != null) {
				levels.add(level);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new ReadLevelException(ReadLevelException.Type.IO);
		}
		return levels;
	}

	// I have to use scanner directly to avoid input stream closing or resource leak issues
	private Level readNextLevel(Scanner scanner) throws ReadLevelException {
		Level levelData;
		List<List<Tile>> readTiles = new ArrayList<List<Tile>>();
		int width = 0;
		int height = 0;
		List<EntityData> entitiesToAdd = new LinkedList<EntityData>();
		String line;		
		while(scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) { // Read until empty line or end of file
			if(!line.startsWith(";")) { // If it's not a comment
				List<Tile> lineTiles = new ArrayList<Tile>();
				line = line.split(";", 1)[0]; // Remove comments
				if(width < line.length()) width = line.length();
				for(char c : line.toCharArray()) {
					Tile redTile = tileCodes.get(c);
					if(redTile == null) {
						Class<? extends Entity> entityClass = entityCodes.get(c);
						if(entityClass != null) {
							int x = lineTiles.size();
							int y = readTiles.size();
							EntityData entityData = new EntityData(entityClass, x, y);
							entitiesToAdd.add(entityData);
							
							lineTiles.add(Tiles.FLOOR);
						} else {
							throw new ReadLevelException(ReadLevelException.Type.UNKNOWN_TILE);	
						}
					} else {
						lineTiles.add(redTile);
					}
				}
				readTiles.add(lineTiles);
			}
		}
		
		height = readTiles.size();
		if(width == 0 || height == 0) {
			return null;
		} else {
			levelData = new Level(width, height);
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					if(x < readTiles.get(y).size()) {
						levelData.setTile(x, y, readTiles.get(y).get(x));
					} else {
						levelData.setTile(x, y, Tiles.VOID);
					}
				}
			}
			for(EntityData entityData : entitiesToAdd) {
				try {
					Entity e = entityData.entityClass.getDeclaredConstructor(Level.class).newInstance(levelData);
					e.setPosition(new Vector2f(entityData.x + 0.5f, entityData.y + 0.5f));
					levelData.addEntity(e);
				} catch (Exception e) {
					throw new ReadLevelException(ReadLevelException.Type.UNKNOWN_ENTITY);	
				}
			}
			return levelData;
		}

	}
	
	private class EntityData {
		
		public final int x, y;
		public final Class<? extends Entity> entityClass;
		
		public EntityData(Class<? extends Entity> entityClass, int x, int y) {
			this.x = x;
			this.y = y;
			this.entityClass = entityClass;
		}
		
	}

}

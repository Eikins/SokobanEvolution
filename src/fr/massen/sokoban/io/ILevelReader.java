package fr.massen.sokoban.io;

import java.io.File;
import java.util.List;

import fr.massen.sokoban.level.LevelData;

public interface ILevelReader {
	
	List<LevelData> readLevelData(File file) throws ReadLevelException;

}

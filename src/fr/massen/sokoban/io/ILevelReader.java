package fr.massen.sokoban.io;

import java.io.File;
import java.util.List;

import fr.massen.sokoban.level.Level;

public interface ILevelReader {
	
	List<Level> readLevels(File file) throws ReadLevelException;

}

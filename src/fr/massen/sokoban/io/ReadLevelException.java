package fr.massen.sokoban.io;

public class ReadLevelException extends Exception {


	private static final long serialVersionUID = 6135401881360904170L;

	private final Type type;
	
	public ReadLevelException(final Type type) {
		this.type = type;
	}
	
	@Override
	public String getMessage() {
		if(type == Type.IO) {
			return "File not found";
		} else {
			return "Unknown tile at (x;y)";
		}

	}
	
	public enum Type {
		IO,
		UNKNOWN_TILE,
		UNKNOWN_ENTITY;
	}
}

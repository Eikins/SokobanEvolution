package fr.massen.sokoban.controller;

import javafx.scene.input.KeyCode;

public interface Controller {
	
	void onKeyPressed(KeyCode keyCode);

	void onKeyReleased(KeyCode keyCode);
	
}

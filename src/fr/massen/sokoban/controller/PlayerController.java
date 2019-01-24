package fr.massen.sokoban.controller;

import fr.massen.sokoban.entities.EntityPlayer;
import fr.massen.sokoban.maths.Vector2f;
import javafx.scene.input.KeyCode;

public class PlayerController implements Controller {
	
	private EntityPlayer player;
	private float moveSpeed = 3f;
	
	private Vector2f movementInput;
	
	public PlayerController(EntityPlayer player) {
		this.player  = player;
		movementInput = new Vector2f(0f, 0f);
	}

	@Override
	public void onKeyPressed(KeyCode keyCode) {
		if(keyCode == KeyCode.LEFT) {
			movementInput.x = -1f;
		} 
		if (keyCode == KeyCode.RIGHT) {
			movementInput.x = 1f;
		}
		
		if(keyCode == KeyCode.UP) {
			movementInput.y = -1f;
		}
		if (keyCode == KeyCode.DOWN) {
			movementInput.y = 1f;
		}
		
		player.setVelocity(movementInput.normalize().scale(moveSpeed));
	}

	@Override
	public void onKeyReleased(KeyCode keyCode) {
		
		if(keyCode == KeyCode.LEFT) {
			if(movementInput.x == -1f) movementInput.x = 0f;
		} 
		if (keyCode == KeyCode.RIGHT) {
			if(movementInput.x == 1f) movementInput.x = 0f;
		}
		
		if(keyCode == KeyCode.UP) {
			if(movementInput.y == -1f) movementInput.y = 0f;
		}
		if (keyCode == KeyCode.DOWN) {
			if(movementInput.y == 1f) movementInput.y = 0f;
		}
		
		player.setVelocity(movementInput.normalize().scale(moveSpeed));
	}
	
	

}

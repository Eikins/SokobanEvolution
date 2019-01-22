package fr.massen.sokoban.controller;

import fr.massen.sokoban.entities.EntityPlayer;
import javafx.scene.input.KeyCode;

public class PlayerController implements Controller {
	
	private EntityPlayer player;
	private float moveSpeed = 3f;
	
	public PlayerController(EntityPlayer player) {
		this.player  = player;
	}

	@Override
	public void onKeyPressed(KeyCode keyCode) {
		if(keyCode == KeyCode.LEFT) {
			player.setVelocityX(-moveSpeed);
		} 
		if (keyCode == KeyCode.RIGHT) {
			player.setVelocityX(moveSpeed);
		}
		
		if(keyCode == KeyCode.UP) {
			player.setVelocityY(-moveSpeed);
		}
		if (keyCode == KeyCode.DOWN) {
			player.setVelocityY(moveSpeed);
		}
	}

	@Override
	public void onKeyReleased(KeyCode keyCode) {
		if(keyCode == KeyCode.LEFT || keyCode == KeyCode.RIGHT) {
			player.setVelocityX(0f);
		}
		
		if(keyCode == KeyCode.UP || keyCode == KeyCode.DOWN) {
			player.setVelocityY(0f);
		}
	}
	
	

}

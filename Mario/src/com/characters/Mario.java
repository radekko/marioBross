package com.characters;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import com.core.EFields;
import com.images.resource.ImageFactory;
import com.movement.EMovement;
import com.movement.MovementFactory;
import com.panels.KeyboardListener;

public class Mario implements IActor {
	
	private int x = 20;
	private int y = 380;
	private int lastY;
	
	private final static int MIN_X = 0;
	private final static int MAX_X = 600-20;
	
	private final static int VERTICAL_STEP_SIZE = 20;
	private final static int HORIZONTAL_STEP_SIZE = 20;
	private final int HOWMANYMOVES = 1;
	private final int HOWMANYMOVESINAIR = 3;
	private boolean isAlive = true;
	
	private EFields imageType = EFields.MARIOFIELD;
	
	private KeyboardListener keyListener;
	private MovementFactory movementFactory;

	public Mario(KeyboardListener keyListener){
		this.keyListener = keyListener;
		movementFactory = new MovementFactory();
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public void setX(int x) {
		this.x = x;
		
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	public int getLastY() {
		return lastY;
	}
	@Override
	public boolean isAlive() {
		return isAlive;
	}
	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	@Override
	public BufferedImage getImage() {
		return ImageFactory.getImage(imageType);
	}
	
	public List<EMovement> getMarioSteps(){
		if(keyListener.isKeyPressed(KeyEvent.VK_LEFT) && keyListener.isKeyPressed(KeyEvent.VK_UP))
			return movementFactory.createMove(EMovement.DIAGONALLEFT,HOWMANYMOVES,HOWMANYMOVESINAIR);
		else if(keyListener.isKeyPressed(KeyEvent.VK_RIGHT) && keyListener.isKeyPressed(KeyEvent.VK_UP))
			return movementFactory.createMove(EMovement.DIAGONALRIGHT,HOWMANYMOVES,HOWMANYMOVESINAIR);
		else if(keyListener.isKeyPressed(KeyEvent.VK_LEFT))
			return movementFactory.createMove(EMovement.LEFT);
		else if(keyListener.isKeyPressed(KeyEvent.VK_RIGHT))
			return movementFactory.createMove(EMovement.RIGHT);
		else if(keyListener.isKeyPressed(KeyEvent.VK_UP)) 
			return movementFactory.createMove(EMovement.UP,HOWMANYMOVES,HOWMANYMOVESINAIR);	
		else 
			return movementFactory.createMove();
	}
	
	@Override
	public void move(EMovement move) {
		lastY = y;
		
		switch (move) {
		case RIGHT:
			x += VERTICAL_STEP_SIZE;
			checkRightEdge();
			break;
		case LEFT:
			x -= VERTICAL_STEP_SIZE;
			checkLeftEdge();
			break;
		case UP:
			y -= HORIZONTAL_STEP_SIZE;
			break;
		case DOWN:
			y += HORIZONTAL_STEP_SIZE;
			break;
		case DIAGONALLEFT:
			x -= VERTICAL_STEP_SIZE;
			y -= HORIZONTAL_STEP_SIZE;
			checkLeftEdge();
			break;
		case DOWNDIAGONALLEFT:
			x -= VERTICAL_STEP_SIZE;
			y += HORIZONTAL_STEP_SIZE;
			checkLeftEdge();
			break;
		case DIAGONALRIGHT:
			x += VERTICAL_STEP_SIZE;
			y -= HORIZONTAL_STEP_SIZE;
			checkRightEdge();
			break;
		case DOWNDIAGONALRIGHT:
			x += VERTICAL_STEP_SIZE;
			y += HORIZONTAL_STEP_SIZE;
			checkRightEdge();
			break;
		default:
			break;
		}
	}

	private void checkLeftEdge(){
		if(x<=MIN_X) x = MIN_X;
	}
	
	private void checkRightEdge(){
	    if(x>=MAX_X) x = MAX_X;
	}

}

package com.movement;

import com.characters.IActor;

public class CharacterMovement {
	private IActor actor;
	private int x;
	private int y;
	private final static int MIN_X = 0;
	private final static int MAX_X = 600-20;
	private boolean changeMoveTowards;
	private int VERTICAL_STEP_SIZE;
	private int HORIZONTAL_STEP_SIZE;
	
	public CharacterMovement(IActor actor,int VERTICAL_STEP_SIZE, int HORIZONTAL_STEP_SIZE) {
		this.actor = actor;
		x = actor.getX();
		y = actor.getY();
		this.VERTICAL_STEP_SIZE = VERTICAL_STEP_SIZE;
		this.HORIZONTAL_STEP_SIZE = HORIZONTAL_STEP_SIZE;
	}
	
	public void move(EMovementTowards moves) {
		changeMoveTowards = false;
		switch (moves) {
		case LEFT:
			x -= VERTICAL_STEP_SIZE;
			break;
		case RIGHT:
			x += VERTICAL_STEP_SIZE;
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
			break;
		case DOWNDIAGONALLEFT:
			x -= VERTICAL_STEP_SIZE;
			y += HORIZONTAL_STEP_SIZE;
			break;
		case DIAGONALRIGHT:
			x += VERTICAL_STEP_SIZE;
			y -= HORIZONTAL_STEP_SIZE;
			break;
		case DOWNDIAGONALRIGHT:
			x += VERTICAL_STEP_SIZE;
			y += HORIZONTAL_STEP_SIZE;
			break;
		default:
			break;
		}
		checkEdges();
		actor.setX(x);
		actor.setY(y);
	}
	
	public boolean isChangeTowards(){
		return changeMoveTowards;
	}
	
	private void checkEdges(){
		if(x>MIN_X && x<MAX_X)
			return;
		if(x<=MIN_X)
			x = MIN_X;
		if(x>=MAX_X)
			x = MAX_X;
		
		changeMoveTowards = true;
	}
	
}

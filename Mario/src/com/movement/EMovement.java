package com.movement;


public enum EMovement {
	LEFT, RIGHT, UP, DOWN, 
	DIAGONALRIGHT, DIAGONALLEFT, DOWNDIAGONALLEFT, DOWNDIAGONALRIGHT, NONE;
	
	public EMovement getComplementMove(EMovement move){
		switch(move){
		case UP:
			return DOWN;
		case DIAGONALRIGHT:
			return DOWNDIAGONALRIGHT;
		case DIAGONALLEFT:
			return DOWNDIAGONALLEFT;
		default:
			return NONE;
		}
	}
}

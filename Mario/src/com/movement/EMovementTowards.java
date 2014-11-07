package com.movement;


public enum EMovementTowards {
	LEFT, RIGHT, UP, DOWN, 
	DIAGONALRIGHT, DIAGONALLEFT, DOWNDIAGONALLEFT, DOWNDIAGONALRIGHT, NONE;
	
	public static EMovementTowards getComplementMove(EMovementTowards move){
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
	
	public static EMovementTowards getReverseMove(EMovementTowards move){
		switch(move){
		case LEFT:
			return RIGHT;
		case RIGHT:
			return LEFT;
		case UP:
			return DOWN;
		case DOWN:
			return UP;	
		case DIAGONALRIGHT:
			return DIAGONALLEFT;
		case DIAGONALLEFT:
			return DIAGONALRIGHT;
		case DOWNDIAGONALRIGHT:
			return DOWNDIAGONALLEFT;
		case DOWNDIAGONALLEFT:
			return DOWNDIAGONALRIGHT;
		default:
			return NONE;
		}
	}
	
	public static boolean isInAir(EMovementTowards move){
		switch(move){
		case LEFT:
			return false;
		case RIGHT:
			return false;
		case UP:
			return true;
		case DOWN:
			return true;
		case DIAGONALRIGHT:
			return true;
		case DIAGONALLEFT:
			return true;
		case DOWNDIAGONALRIGHT:
			return true;
		case DOWNDIAGONALLEFT:
			return true;
		default:
			return false;
		}
	}
}

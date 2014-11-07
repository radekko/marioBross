package com.movement;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.characters.Mario;
import com.panels.KeyboardListener;

public class MarioMoves {
	private Mario mario;
	private KeyboardListener keyListener;
	private CharacterMovement movement;
	private final int HOWMANYMOVES = 1;
	private final int HOWMANYMOVESINAIR = 3;
	
	private final static int VERTICAL_STEP_SIZE = 20;
	private final static int HORIZONTAL_STEP_SIZE = 20;
	private final static int INDEX_CURRENT_MOVE = 0;
	private List<EMovementTowards> listOfMoves = new ArrayList<EMovementTowards>();
	private ListOfStepsGenerator listOfStepsGenerator;
	private boolean leftTowardsInAir;
	
	public MarioMoves(Mario mario, KeyboardListener keyListener){
		this.mario = mario;
		this.keyListener = keyListener;
		movement = new CharacterMovement(mario,VERTICAL_STEP_SIZE,HORIZONTAL_STEP_SIZE);
		listOfStepsGenerator = new ListOfStepsGenerator();
	}
	
	public void updateMario(){
		if(noMoving())
			return;
		
		if(listOfMoves.isEmpty())
			listOfMoves = listOfStepsGenerator.createListOfMarioSteps(
					keyListener,HOWMANYMOVES,HOWMANYMOVESINAIR);
//		else if(!listOfMoves.isEmpty() && isInAir() && isMarioMovingInFly()){
//			changeStep();
//		}
			
		moveMario();
	}
	
	private boolean isInAir(){
		if(EMovementTowards.isInAir(listOfMoves.get(INDEX_CURRENT_MOVE)))
			return true;
		return false;
	}
	
	private boolean noMoving(){
		if(listOfMoves.isEmpty() && !isMarioMoving())
			return true;
		return false;
	}
	
	private boolean isMarioMoving(){
		if(keyListener.isKeyPressed(KeyEvent.VK_LEFT) ||
				keyListener.isKeyPressed(KeyEvent.VK_RIGHT) ||
				keyListener.isKeyPressed(KeyEvent.VK_UP))
					return true;
		return false;
	}
	
	private boolean isMarioMovingInFly(){
		if(!keyListener.isKeyPressed(KeyEvent.VK_LEFT) &&
				!keyListener.isKeyPressed(KeyEvent.VK_RIGHT))
		return false;
		
		if(keyListener.isKeyPressed(KeyEvent.VK_LEFT)){
			leftTowardsInAir = true;
		} else {
			leftTowardsInAir = false;
		}
		
		return true;
	}
	
//	private boolean isMarioMovingInFly(){
//		if(keyListener.isKeyPressed(KeyEvent.VK_LEFT) ||
//				keyListener.isKeyPressed(KeyEvent.VK_RIGHT))
//					return true;
//		return false;
//	}
	
	private void moveMario(){
		mario.setLastY(mario.getY());
		movement.move(listOfMoves.get(INDEX_CURRENT_MOVE));
		listOfMoves.remove(INDEX_CURRENT_MOVE);
	}
	
	private void changeStep(){
		EMovementTowards towardsToChange = listOfMoves.get(INDEX_CURRENT_MOVE);
		
	}
}

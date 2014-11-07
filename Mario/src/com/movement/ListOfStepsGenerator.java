package com.movement;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.panels.KeyboardListener;

public class ListOfStepsGenerator {
	private List<EMovementTowards> monsterSteps = new ArrayList<EMovementTowards>();
	private MovementFactory movementFactory;
	
	public ListOfStepsGenerator(){
		movementFactory = new MovementFactory();
	}
	
	public List<EMovementTowards> createListOfSteps(EMovementTowards movementTowards){
		monsterSteps.clear();
		monsterSteps.addAll(
				movementFactory.createMove(movementTowards));
		return monsterSteps;
	}
	
	public List<EMovementTowards> createListOfSteps(EMovementTowards movementTowards,
			int HOWMANYMOVES,int HOWMANYMOVESINAIR){
		monsterSteps.clear();
		monsterSteps.addAll(
				movementFactory.createMove(movementTowards,HOWMANYMOVES,HOWMANYMOVESINAIR));
		return monsterSteps;
	}
	
	public List<EMovementTowards> createListOfMarioSteps(KeyboardListener keyListener,int HOWMANYMOVES,int HOWMANYMOVESINAIR){
		if(keyListener.isKeyPressed(KeyEvent.VK_LEFT) && keyListener.isKeyPressed(KeyEvent.VK_UP))
			return movementFactory.createMove(EMovementTowards.DIAGONALLEFT,HOWMANYMOVES,HOWMANYMOVESINAIR);
		else if(keyListener.isKeyPressed(KeyEvent.VK_RIGHT) && keyListener.isKeyPressed(KeyEvent.VK_UP))
			return movementFactory.createMove(EMovementTowards.DIAGONALRIGHT,HOWMANYMOVES,HOWMANYMOVESINAIR);
		else if(keyListener.isKeyPressed(KeyEvent.VK_LEFT))
			return movementFactory.createMove(EMovementTowards.LEFT);
		else if(keyListener.isKeyPressed(KeyEvent.VK_RIGHT))
			return movementFactory.createMove(EMovementTowards.RIGHT);
		else if(keyListener.isKeyPressed(KeyEvent.VK_UP)) 
			return movementFactory.createMove(EMovementTowards.UP,HOWMANYMOVES,HOWMANYMOVESINAIR);	
		else 
			return movementFactory.createMove();
	}
	
	
}

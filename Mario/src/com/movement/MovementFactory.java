package com.movement;

import java.util.ArrayList;
import java.util.List;


public class MovementFactory {
	
	private List<EMovementTowards> steps;
	
	public MovementFactory(){
		steps = new ArrayList<EMovementTowards>();
	}
	public List<EMovementTowards> createMove(){
		steps.clear();
		return steps;
	}
	
	public List<EMovementTowards> createMove(EMovementTowards m){
		steps.clear();
		steps.add(m);
		return steps;
	}
	
	public List<EMovementTowards> createMove(EMovementTowards movement,int HOWMANYMOVES,int HOWMANYMOVESINAIR){
		steps.clear();
		EMovementTowards completeMove = EMovementTowards.getComplementMove(movement);

		if(completeMove == EMovementTowards.NONE){
			for(int i = 0; i < HOWMANYMOVES ; i++)
				steps.add(movement);
		}
		else {
			for(int i = 0; i < HOWMANYMOVESINAIR ; i++)
				steps.add(movement);
			for(int j = 0; j < HOWMANYMOVESINAIR ; j++)
				steps.add(completeMove);
		}
		return steps;
	}
	

}

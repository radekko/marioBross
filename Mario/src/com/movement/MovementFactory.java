package com.movement;

import java.util.ArrayList;
import java.util.List;


public class MovementFactory {
	
	private List<EMovement> steps;
	
	public MovementFactory(){
		steps = new ArrayList<EMovement>();
	}
	public List<EMovement> createMove(){
		steps.clear();
		return steps;
	}
	
	public List<EMovement> createMove(EMovement m){
		steps.clear();
		steps.add(m);
		return steps;
	}
	
	public List<EMovement> createMove(EMovement m,int HOWMANYMOVES,int HOWMANYMOVESINAIR){
		steps.clear();
		EMovement completeMove = m.getComplementMove(m);

		if(completeMove == EMovement.NONE){
			for(int i = 0; i < HOWMANYMOVES ; i++)
				steps.add(m);
		}
		else {
			for(int i = 0; i < HOWMANYMOVESINAIR ; i++)
				steps.add(m);
			for(int j = 0; j < HOWMANYMOVESINAIR ; j++)
				steps.add(completeMove);
		}
		return steps;
	}
	

}

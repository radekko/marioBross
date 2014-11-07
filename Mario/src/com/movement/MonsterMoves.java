package com.movement;

import java.util.List;

import com.characters.IActor;


public class MonsterMoves {
	private List<EMovementTowards> monsterSteps;
	private CharacterMovement movement;
	int INDEX_CURRENT_MOVE = 0;
	
	
	public MonsterMoves(IActor monster,
			int VERTICAL_STEP_SIZE,int HORIZONTAL_STEP_SIZE,
			List<EMovementTowards> monsterSteps){

		this.monsterSteps = monsterSteps;
		movement = new CharacterMovement(monster,
						VERTICAL_STEP_SIZE,HORIZONTAL_STEP_SIZE);
	}
	
	public void updateMonster() {
		if(INDEX_CURRENT_MOVE == monsterSteps.size())
			INDEX_CURRENT_MOVE = 0;

		movement.move(monsterSteps.get(INDEX_CURRENT_MOVE));
		if(movement.isChangeTowards())
			reverseTowards();
		
		INDEX_CURRENT_MOVE++;
	}
	
	private void reverseTowards(){
		for (int i = 0; i < monsterSteps.size(); i++) {
			EMovementTowards reverseStep = monsterSteps.get(i);
			reverseStep = EMovementTowards.getReverseMove(reverseStep);
			monsterSteps.set(i,reverseStep);
		}
	}
}

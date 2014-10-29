package com.characters;

import java.awt.image.BufferedImage;

import com.core.EFields;
import com.images.resource.ImageFactory;
import com.movement.MonsterStepsList;
import com.movement.EMovement;
import com.movement.MovementFactory;

public class DuckMonster implements IActor{
	
	private int x=560;
	private int y=380;
	private final static int MIN_X = 0;
	private final static int MAX_X = 600-20;
	
	private final static int VERTICAL_STEP_SIZE = 10;
	private final static int HORIZONTAL_STEP_SIZE = 10;
	private final int HOWMANYMOVES = 1;
	private final int HOWMANYMOVESINAIR = 3;
	
	private EFields image = EFields.MONSTERFIELD;
	
	private boolean isAlive = true;
	private boolean changeTowards = false;
	private boolean ifRightDirection=false;
	
	private MonsterStepsList<EMovement> monsterSteps;
	private MovementFactory movementFactory;

	public DuckMonster(){
		movementFactory = new MovementFactory();
		monsterSteps = new MonsterStepsList<EMovement>();
		addSteps(EMovement.DIAGONALLEFT);	
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
	
	@Override
	public BufferedImage getImage() {
		return ImageFactory.getImage(image);
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
	public void move(EMovement m) {
		
		moveInChoosenTowards(monsterSteps);
		
		if(changeTowards){
			if(ifRightDirection)
				addSteps(EMovement.DIAGONALLEFT);					
			else
				addSteps(EMovement.DIAGONALRIGHT);	
		}
	}
	
	private void addSteps(EMovement m){
		monsterSteps.clear();
		monsterSteps.addAll(
				movementFactory.createMove(m,HOWMANYMOVES,HOWMANYMOVESINAIR));
	}
	
	private void moveInChoosenTowards(MonsterStepsList<EMovement> moves) {
		switch (moves.get()) {
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
		if(x<=MIN_X) {
			x = MIN_X;
			ifRightDirection = false;
			changeTowards = true;
		}
		else
			changeTowards = false;
	}
	
	private void checkRightEdge(){
	    if(x>=MAX_X){
	    	x = MAX_X;
	    	ifRightDirection = true;
	    	changeTowards = true;
	    }
	    else
			changeTowards = false;
	}

}


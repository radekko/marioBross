package com.characters;

import java.awt.image.BufferedImage;

import com.core.EFields;
import com.images.resource.ImageFactory;
import com.movement.EMovementTowards;
import com.movement.ListOfStepsGenerator;
import com.movement.MonsterMoves;

public class Monster implements IActor{

	private int x=500;
	private int y=380;
	private final static int VERTICAL_STEP_SIZE = 5;
	private final static int HORIZONTAL_STEP_SIZE = 0;
	
	
	private EFields image = EFields.MONSTERFIELD;

	private boolean isAlive = true;
	private MonsterMoves monsterMove;
	private EMovementTowards currentTowards = EMovementTowards.LEFT;
	
	public Monster(){
		monsterMove = new MonsterMoves(this,
				VERTICAL_STEP_SIZE,HORIZONTAL_STEP_SIZE,
				new ListOfStepsGenerator().createListOfSteps(currentTowards));
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
	public void update() {
		monsterMove.updateMonster();
	}

}

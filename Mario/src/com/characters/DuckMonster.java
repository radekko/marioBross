package com.characters;

import java.awt.image.BufferedImage;

import com.core.EFields;
import com.images.resource.ImageFactory;
import com.movement.EMovementTowards;
import com.movement.ListOfStepsGenerator;
import com.movement.MonsterMoves;

public class DuckMonster implements IActor{
	
	private int x=560;
	private int y=380;
	private final static int VERTICAL_STEP_SIZE = 10;
	private final static int HORIZONTAL_STEP_SIZE = 10;
	private final int HOWMANYMOVES = 1;
	private final int HOWMANYMOVESINAIR = 3;
	
	private EFields image = EFields.MONSTERFIELD;
	
	private boolean isAlive = true;
	
	private MonsterMoves monsterMove;
	private EMovementTowards currentTowards = EMovementTowards.DIAGONALLEFT;

	public DuckMonster(){
		monsterMove = new MonsterMoves(this,
				VERTICAL_STEP_SIZE,HORIZONTAL_STEP_SIZE,
				new ListOfStepsGenerator().createListOfSteps(currentTowards,HOWMANYMOVES,HOWMANYMOVESINAIR));
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
	
	public void update(){
		monsterMove.updateMonster();
	}

}


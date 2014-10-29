package com.characters;

import java.awt.image.BufferedImage;

import com.core.EFields;
import com.images.resource.ImageFactory;
import com.movement.EMovement;

public class Monster implements IActor{

	private int x=500;
	private int y=380;
	private final static int MIN_X = 0;
	private final static int MAX_X = 600-20;
	private final static int VERTICAL_STEP_SIZE = 5;
	
	private EFields image = EFields.MONSTERFIELD;

	private boolean isAlive = true;
	private boolean ifRightDirection=false;
	
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
		if(x<=MIN_X)
			ifRightDirection = true;
		else if(x>=MAX_X)
			ifRightDirection = false;
		
		x = (ifRightDirection) ? x + VERTICAL_STEP_SIZE : x - VERTICAL_STEP_SIZE;
	}


}

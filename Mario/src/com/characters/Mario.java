package com.characters;

import java.awt.image.BufferedImage;

import com.core.EFields;
import com.images.resource.ImageFactory;
import com.movement.MarioMoves;
import com.panels.KeyboardListener;

public class Mario implements IActor {
	
	private int x = 20;
	private int y = 380;
	private int lastY;
	private boolean isAlive = true;
	
	private EFields imageType = EFields.MARIOFIELD;
	
	private MarioMoves marioMoves;

	public Mario(KeyboardListener keyListener){
		marioMoves = new MarioMoves(this,keyListener);
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
	public int getLastY() {
		return lastY;
	}
	public void setLastY(int lastY) {
		this.lastY = lastY;
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
	public BufferedImage getImage() {
		return ImageFactory.getImage(imageType);
	}
	
	public void update(){
		marioMoves.updateMario();
	}

}

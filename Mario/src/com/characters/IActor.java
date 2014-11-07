package com.characters;

import java.awt.image.BufferedImage;

import com.movement.EMovementTowards;


public interface IActor {
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	void update();
	
	BufferedImage getImage();
	
	boolean isAlive();
	void setAlive(boolean isAlive);
}

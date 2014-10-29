package com.characters;

import java.awt.image.BufferedImage;

import com.movement.EMovement;


public interface IActor {
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	void move(EMovement m);
	
	BufferedImage getImage();
	
	boolean isAlive();
	void setAlive(boolean isAlive);
}

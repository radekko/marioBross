package com.panels;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.characters.IActor;
import com.core.EFields;
import com.core.GameRunnable;
import com.images.resource.ImageFactory;

public class MainPanel extends JPanel{
	
	static {
		skyField = ImageFactory.getImage(EFields.SKYFIELD);
		grassField = ImageFactory.getImage(EFields.GRASSFIELD);
	}

	private static final long serialVersionUID = 1L;
	
	private static BufferedImage skyField;
	private static BufferedImage grassField;
	
	private final KeyboardListener keyListener = new KeyboardListener();
	private final GameRunnable gameRunnable = new GameRunnable(this,keyListener);

	public MainPanel() {
		setLayout(new BorderLayout());
		setFocusable(true);
		addKeyListener(keyListener);
	}
	
	@Override
    public void addNotify() {
        super.addNotify();
        
        Thread t = new Thread(gameRunnable);
		t.start();
    }

	@Override
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			drawBoard(g2d);
			drawMario(g2d);
			drawMonster(g2d);
	}

	private void drawMario(Graphics2D g2d) {
		g2d.drawImage(
				gameRunnable.getMario().getImage(),
				gameRunnable.getMario().getX(),
				gameRunnable.getMario().getY(), this);
	}

	private void drawMonster(Graphics2D g2d) {
		for(IActor character : gameRunnable.getAliveMonsters())
			g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
	}

	private void drawBoard(Graphics2D g2d) {
		for (int i = 0; i < 600; i += 100)
			for (int j = 0; j < 400; j += 100)
				g2d.drawImage(skyField, i, j, this);

		for (int i = 0; i < 600; i += 100)
			for (int j = 400; j < 600; j += 100)
				g2d.drawImage(grassField, i, j, this);
	}
	
	
}


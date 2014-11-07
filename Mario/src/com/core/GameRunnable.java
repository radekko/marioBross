package com.core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.characters.DuckMonster;
import com.characters.IActor;
import com.characters.Mario;
import com.characters.Monster;
import com.panels.KeyboardListener;

public class GameRunnable implements Runnable {

	private final static long SLEEPTIME = 100;
	
	private Mario mario;
	private Monster monster;
	private DuckMonster duckMonster;

	private List<IActor> aliveMonsters;
	private DeadZone deathZone;
	
	private JPanel gamePanel;
	
	public GameRunnable(JPanel gamePanel, KeyboardListener keyListener) {
		this.gamePanel = gamePanel;
		mario = new Mario(keyListener);
		monster = new Monster();
		duckMonster = new DuckMonster();
		aliveMonsters = new ArrayList<IActor>();
		
		aliveMonsters.add(monster);
		aliveMonsters.add(duckMonster);
	}
	
	public Mario getMario(){
		return mario;
	}

	public List<IActor> getAliveMonsters() {
		return aliveMonsters;
	}

	@Override
	public void run() {
		while(mario.isAlive()){
			updateGame();
		}
		JOptionPane.showMessageDialog(null, "Mario is death.");
		System.exit(0);
	}
	
	private void updateGame(){
		updateMonsters();
		mario.update();
		//checkDeathZone();
		repaintAndSleep();
	}
	
	private void updateMonsters(){
		for(IActor monsterCharacter : aliveMonsters)
			monsterCharacter.update();	
	}
	
	private void repaintAndSleep() {
		gamePanel.repaint();
		sleep(SLEEPTIME);
	}
	
	private void checkDeathZone() {
		deathZone = new DeadZone(aliveMonsters, mario);
		aliveMonsters =  deathZone.checkCollision();
		
		if(deathZone.isMarioDead())
			mario.setAlive(false);
	}
	
	private void sleep(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

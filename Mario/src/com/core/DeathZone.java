package com.core;

import java.util.Iterator;
import java.util.List;

import com.characters.IActor;
import com.characters.Mario;

public class DeathZone {

	private List<IActor> aliveMonsters;
	private Mario mario;
	private int lenght = 20;
	
	public DeathZone(List<IActor> aliveMonsters, Mario mario) {
		this.aliveMonsters = aliveMonsters;
		this.mario = mario;
	}
	
	public List<IActor> checkCollision() {
		Iterator<IActor> itr = aliveMonsters.iterator();
		while(itr.hasNext()) {
			IActor monsterCharacter = itr.next();
			
			if(mario.getX()+lenght>=monsterCharacter.getX() 
					&& mario.getX()+lenght<=monsterCharacter.getX()+lenght 
					||
					monsterCharacter.getX()+lenght>=mario.getX() 
					&& monsterCharacter.getX()+lenght<=mario.getX()+lenght) {
				
				//check if mario hit
				if(mario.getY()<monsterCharacter.getY()){
					if(mario.getY()+lenght>=monsterCharacter.getY() 
							&& mario.getY()+lenght<=monsterCharacter.getY()+lenght)
						itr.remove();
				}
				//check if monster hit
				else{
					if(mario.getY()>=monsterCharacter.getY() && mario.getY()<=monsterCharacter.getY()+lenght){
						System.out.println("monster hit");
						mario.setAlive(false);
//						System.out.println("mario.getX(): "+mario.getX());
//						System.out.println("monsterCharacter: "+monsterCharacter.getX());
//						System.out.println("mario.getY(): "+mario.getY());
//						System.out.println("monsterCharacter: "+monsterCharacter.getY());
					}
				}
			}
		}
		return aliveMonsters;
	}
}

package com.core;

import java.util.Iterator;
import java.util.List;

import com.characters.IActor;
import com.characters.Mario;

public class DeadZone {

	private List<IActor> aliveMonsters;
	private Mario mario;
	private int lenght;
	//if mario is go down
	private boolean marioIsInCompleteMove;
	private boolean isMonsterDead;
	private boolean isMarioDead = false;
	
	public boolean isMarioDead() {
		return isMarioDead;
	}

	public DeadZone(List<IActor> aliveMonsters, Mario mario) {
		this.aliveMonsters = aliveMonsters;
		this.mario = mario;
		this.lenght = mario.getImage().getHeight();
		this.marioIsInCompleteMove = ( mario.getLastY()-mario.getY()>0 )? true : false;
	}
	
	public List<IActor> checkCollision() {
		
		Iterator<IActor> itr = aliveMonsters.iterator();
		int Xmar = mario.getX();
		int Ymar = mario.getY();
		
		while(itr.hasNext()) {
			IActor monsterCharacter = itr.next();
			int Xmon = monsterCharacter.getX();
			int Ymon = monsterCharacter.getY();
			
			if(chceckIfCollisionOnOX(Xmar,Ymar,Xmon,Ymon)){
				isMonsterDead = checkIfMarioHit(Xmar,Ymar,Xmon,Ymon);
				isMarioDead = checkIfMarioIsDead(Xmar,Ymar,Xmon,Ymon);
			}
			else
				isMonsterDead = false;
			
			if(isMarioDead)
				break;
			
			if(isMonsterDead)
				itr.remove();
		}
		return aliveMonsters;
	}
	
	private boolean chceckIfCollisionOnOX(int Xmar, int Ymar,int Xmon,int Ymon){
		if(Xmar+lenght>=Xmon && Xmar+lenght<=Xmon+lenght || Xmon+lenght>=Xmar && Xmon+lenght<=Xmar+lenght)
			return true;
		return false;
	}
	
	private boolean checkIfMarioHit(int Xmar, int Ymar,int Xmon,int Ymon){
		if(Ymar<Ymon && Ymar+lenght>=Ymon && Ymar+lenght<=Ymon+lenght && marioIsInCompleteMove)
			return true;
		return false;
	}
	
	private boolean checkIfMarioIsDead(int Xmar, int Ymar,int Xmon,int Ymon){
		if(Ymar>=Ymon && Ymar<=Ymon+lenght && !marioIsInCompleteMove)
				return true;
		return false;
	}
}

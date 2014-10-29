package com.core;


public enum EFields {
	MARIOFIELD("mario.jpg"), MONSTERFIELD("monster.jpg"), SKYFIELD("blue.jpg"), GRASSFIELD("green.jpg");
	
	private String name;

	private EFields(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}

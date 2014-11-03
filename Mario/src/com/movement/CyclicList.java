package com.movement;

import java.util.ArrayList;

public class CyclicList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;
	private int count = -1;

	public E get(){
		return this.get(0);
	}
	
	@Override
	public E get(int index) {
		count++;

		if (count == size()) {
			count = 0;
		}
		
		return super.get(count);
	}
}

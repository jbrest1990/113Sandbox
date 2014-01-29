package com.me.mygdxgame;

public enum Color {
	RED (1), 
	BLUE (2), 
	PURPLE (3), 
	YELLOW (4), 
	ORANGE (5), 
	GREEN (6);
	
	private int value;
	
	Color(int value) 
	{
		 this.value = value;
	}
	
	public int value()
	{
		return value;
	}
}

package com.me.cs133game;

import com.badlogic.gdx.Gdx;

public class Player 
{
	public int score;

	public int multiplier;
	public int nextMultiplier;
	public int comboBar;
	public boolean active;
	public int health;
	public PlayerType playerType;
	
	public Player(PlayerType type)
	{
		playerType = type;
		score = 0;
		multiplier = 1;
		comboBar = 0;
		active = true;
		health = playerType.health;
	}
	
	public void onMiss(){
		nextMultiplier = 0;
		multiplier = 1;
		Gdx.app.log("debug", "missed a spuzzy");
	}
	
	public void increaseScore(int value){
		score+=value*multiplier;
		comboBar+=value*multiplier;
		nextMultiplier+=value;
		Gdx.app.log("debug", "kill for " + (value*multiplier) + " points");
		if(nextMultiplier>=10)//arbitrary value
		{
			nextMultiplier = 0;
			multiplier++;
			Gdx.app.log("debug", "multiplier increased to " + multiplier);
		}
	}
	
	public boolean damage(int value){
		health-=value;
		Gdx.app.log("debug", "damaged by " + value + " amount with " + health + " remaining health");
		return health <= 0;
	}
}

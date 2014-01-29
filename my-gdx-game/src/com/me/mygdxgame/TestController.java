package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class TestController {
	
	private static TestController controller = new TestController();
	
	public static TestController get(){
		return controller;
	}
	
	private TestController(){
		
	}
	
	int lastControl = 0;
	
	public void onUpdate(double partialTime){
		int num = 0;
		if(Gdx.input.isKeyPressed(Keys.W))
			num|=1;
		if(Gdx.input.isKeyPressed(Keys.A))
			num|=2;
		if(Gdx.input.isKeyPressed(Keys.D))
			num|=4;
		if(num==lastControl)
			return;
		if((num&1)==1)
		{
			ScreenManager.get().changeScreen("test1");
			return;
		}
		if((num&2)==2){
			ScreenManager.get().changeScreen("test2");
			return;
		}
		if((num&4)==4){
			ScreenManager.get().changeScreen("test3");
			return;
		}
	}

}

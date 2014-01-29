package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class TestMenuScreen2 extends MenuScreen{
	
	public TestMenuScreen2(){
		addButton(AssetsManager.get().getRegion("red"), AssetsManager.get().getRegion("green"), Gdx.graphics.getWidth()/2-AssetsManager.get().getRegion("red").getRegionWidth()/2, Gdx.graphics.getHeight()/2-AssetsManager.get().getRegion("red").getRegionHeight()/2);
	}
	
	public void show(){
		InputHandler.get().addListener(this);
	}
	
	public void hide(){
		InputHandler.get().removeListener(this);
	}
	
	public boolean buttonPressed(Button b){
		ScreenManager.get().changeScreen("game");
		return false;
	}
	
	public void render(float delta) {
		super.render(delta);
		
	}

}

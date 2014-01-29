package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class TestMenuScreen extends MenuScreen {
	
	private Button button1;
	private Button button2;
	
	public TestMenuScreen(){
		button1 = addButton(AssetsManager.get().getRegion("red"), AssetsManager.get().getRegion("green"), Gdx.graphics.getWidth()/2-AssetsManager.get().getRegion("red").getRegionWidth()/2, Gdx.graphics.getHeight()/4-AssetsManager.get().getRegion("red").getRegionHeight()/2);
		button2 = addButton(AssetsManager.get().getRegion("blue"), AssetsManager.get().getRegion("yellow"), Gdx.graphics.getWidth()/2-AssetsManager.get().getRegion("blue").getRegionWidth()/2, Gdx.graphics.getHeight()*3/4-AssetsManager.get().getRegion("blue").getRegionHeight()/2);
	}
	
	public void show(){
		InputHandler.get().addListener(this);
	}
	
	public void hide(){
		InputHandler.get().removeListener(this);
	}
	
	public boolean buttonPressed(Button b){
		if(b.equals(button1)){
			ScreenManager.get().changeScreen("test2");
		}
		if(b.equals(button2)){
			ScreenManager.get().changeScreen("mainmenu");
		}
		return false;
	}
	
	public void render(float delta) {
		super.render(delta);
		
	}

}

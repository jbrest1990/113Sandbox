package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class TestMainMenuScreen extends MenuScreen{
	
	public TestMainMenuScreen(){
//		super(new TextureRegion(new Texture(Gdx.files.internal("data/loadscreen.png")), 0, 0, 1129, 1438));
		super(AssetsManager.get().getRegion("background"));
		addButton(AssetsManager.get().getRegion("blue"), AssetsManager.get().getRegion("yellow"), Gdx.graphics.getWidth()/2-AssetsManager.get().getRegion("blue").getRegionWidth()/2, Gdx.graphics.getHeight()/2-AssetsManager.get().getRegion("blue").getRegionHeight()/2);
	}
	
	public void show(){
		InputHandler.get().addListener(this);
	}
	
	public void hide(){
		InputHandler.get().removeListener(this);
	}
	
	public boolean buttonPressed(Button b){
		ScreenManager.get().changeScreen("test1");
		return true;
	}

}

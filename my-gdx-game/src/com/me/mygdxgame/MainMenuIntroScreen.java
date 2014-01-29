package com.me.mygdxgame;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MainMenuIntroScreen extends MenuScreen {
	
	public MainMenuIntroScreen(){
		super(480, 800, AssetsManager.get().loadTextureRegion("backgroundmainmenu", "data/menu_bg.png", 0, 0, 480, 800));
		AssetsManager.get().loadTextureRegion("ropes", "data/mainropes.png", 0, 0, 200, 695);
		AssetsManager.get().loadTextureRegion("mainmenulogo", "data/main_logo.png", 0, 0, 309, 83);
		AssetsManager.get().loadTextureRegion("mainmenuplay", "data/menu_play_norm.png", 0, 0, 267, 128);
		AssetsManager.get().loadTextureRegion("mainmenuin", "data/menu_in_norm.png", 0, 0, 267, 128);
		AssetsManager.get().loadTextureRegion("mainmenuhigh", "data/menu_high_norm.png", 0, 0, 267, 128);
		AssetsManager.get().loadTextureRegion("mainmenuexit", "data/menu_exit_norm.png", 0, 0, 267, 128);
	}
	
	public void show(){
		super.show();
		Actor a = new Image(AssetsManager.get().getRegion("ropes"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("ropes").getRegionWidth()/2, 800);
		a.addAction(generateBoardAction(AssetsManager.get().getRegion("ropes").getRegionWidth()/2, AssetsManager.get().getRegion("ropes").getRegionHeight()));
		a = new Image(AssetsManager.get().getRegion("mainmenuplay"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800+128*3);
		a.addAction(generateBoardAction(AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()+40+95));
		a = new Image(AssetsManager.get().getRegion("mainmenuin"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800+128*2);
		a.addAction(generateBoardAction(AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()+40+95+128));
		a = new Image(AssetsManager.get().getRegion("mainmenuhigh"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800+128);
		a.addAction(generateBoardAction(AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()+40+95+128*2));
		a = new Image(AssetsManager.get().getRegion("mainmenuexit"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800);
		a.addAction(generateBoardAction(AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()+40+95+128*3));
		a = new Image(AssetsManager.get().getRegion("mainmenulogo"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("mainmenulogo").getRegionWidth()/2, 800);
		a.addAction(sequence(delay(1+0.75f+0.25f+0.3f), 
				moveTo(240-AssetsManager.get().getRegion("mainmenulogo").getRegionWidth()/2, 800 - AssetsManager.get().getRegion("mainmenulogo").getRegionHeight()/2 - 67, 0.25f), 
				run(new Runnable(){
					public void run(){
						ScreenManager.get().changeScreen("mainmenu");
					}
				})));
	}
	
	private Action generateBoardAction(float x, float y){
		return sequence(delay(1),
				moveTo(240-x, 800-y, 0.75f),
				moveTo(240-x, 800-y+20, 0.25f),
				moveTo(240-x, 800-y, 0.3f));
	}
	
	public void hide(){
		super.hide();
		clear();
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		ScreenManager.get().changeScreen("mainmenu");
		return true;
	}

}

package com.me.cs133game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MainMenuScreen extends MenuScreen {
	private Button play;
	private Button in;
	private Button high;
	private Button exit;
	
	public MainMenuScreen(){
		super(512, 1024, AssetsManager.get().getRegion("background2"));
		/*Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		texture = new Texture(Gdx.files.internal("data/background2.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		tower = new Texture(Gdx.files.internal("data/tower1.png"));
		tower.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		int textureWidth = tower.getWidth();
		int textureHeight = tower.getHeight();
		
		TextureRegion region2 = new TextureRegion(tower, 0, 0, textureWidth, textureHeight);
		towerSprite = new Sprite(region2);
		towerSprite.setSize(.1f,.1f);
		towerSprite.setOrigin(0, 0);
		towerSprite.setPosition(-towerSprite.getWidth()/2,-towerSprite.getHeight()/2);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		towerSprite.draw(batch);
		batch.end();*/
		/*AssetsManager.get().loadTextureRegion("mainmenuplayp", "data/menu_play_pressed.png", 0, 0, 267, 128);
		AssetsManager.get().loadTextureRegion("mainmenuinp", "data/menu_in_pressed.png", 0, 0, 267, 128);
		AssetsManager.get().loadTextureRegion("mainmenuhighp", "data/menu_high_pressed.png", 0, 0, 267, 128);
		AssetsManager.get().loadTextureRegion("mainmenuexitp", "data/menu_exit_pressed.png", 0, 0, 267, 128);
		Actor a = new Image(AssetsManager.get().getRegion("ropes"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("ropes").getRegionWidth()/2, 800-AssetsManager.get().getRegion("ropes").getRegionHeight());
		a = new Image(AssetsManager.get().getRegion("mainmenulogo"));
		myStage.addActor(a);
		a.setPosition(240-AssetsManager.get().getRegion("mainmenulogo").getRegionWidth()/2, 800 - AssetsManager.get().getRegion("mainmenulogo").getRegionHeight()/2 - 67);*/
		play = addButton(AssetsManager.get().getRegion("mainmenuplay"), AssetsManager.get().getRegion("mainmenuplay"), 200-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800-AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()-40-95);
		//in = addButton(AssetsManager.get().getRegion("mainmenuin"), AssetsManager.get().getRegion("mainmenuinp"), 240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800-AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()-40-95-128);
		//high = addButton(AssetsManager.get().getRegion("mainmenuhigh"), AssetsManager.get().getRegion("mainmenuhighp"), 240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800-AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()-40-95-128*2);
		//exit = addButton(AssetsManager.get().getRegion("mainmenuexit"), AssetsManager.get().getRegion("mainmenuexitp"), 240-AssetsManager.get().getRegion("mainmenuplay").getRegionWidth()/2, 800-AssetsManager.get().getRegion("mainmenuplay").getRegionHeight()-40-95-128*3);
//		a = new Image(AssetsManager.get().getRegion("boards"));
//		myStage.addActor(a);
//		a.setPosition(240-AssetsManager.get().getRegion("boards").getRegionWidth()/2, 800-AssetsManager.get().getRegion("boards").getRegionHeight()-20);
	}
	
	public boolean buttonPressed(Button b){
		if(b.equals(play)){
			Gdx.app.log("debug", "play game");
			ScreenManager.get().changeScreen("game");
		}
		else if(b.equals(in)){
			Gdx.app.log("debug", "instructions");
		}
		else if(b.equals(high)){
			ScreenManager.get().changeScreen("highscore");
			Gdx.app.log("debug", "high score");
		}
		else if(b.equals(exit)){
			Gdx.app.exit();
			Gdx.app.log("debug", "exit");
		}
		return false;
	}

}

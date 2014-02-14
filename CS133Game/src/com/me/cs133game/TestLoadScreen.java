package com.me.cs133game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class TestLoadScreen extends BasicScreen {
	
	public TestLoadScreen(){
		//this screen's texture has to be force loaded, or else it will error
		super(480, 800, new TextureRegion(AssetsManager.get().forceLoadTexture("data/background2.png"), 0, 0, 480, 800));
		/*Array<TextureRegion> regions = new Array<TextureRegion>();
		regions.add(new TextureRegion(AssetsManager.get().forceLoadTexture("data/loading_1.png"), 0, 0, 194, 247));
		regions.add(new TextureRegion(AssetsManager.get().forceLoadTexture("data/loading_2.png"), 0, 0, 194, 247));
		regions.add(new TextureRegion(AssetsManager.get().forceLoadTexture("data/loading_3.png"), 0, 0, 194, 247));*/
		//myStage.addActor(new AnimationActor(new Animation(0.125f, regions), 240-97, 400-123));
		
	}
	
	public void show(){
		super.show();
		AssetsManager.get().loadTexture("data/background2.png");


	}
	
	public void render(float delta){
		super.render(delta);
		if(AssetsManager.get().update()){
			//regions loading should ideally go in screen constructors, which will be called here
			//class scope bitch
			AssetsManager.get().loadTextureRegion("background2", "data/background2.png", 0, 0, 512, 1024);
//			loadEnemyType(1, 5, 1, new String[][]{ {"redm", "blum", null, "yelm", null, null}, {"detm", "detm", null, "detm", null, null} }, 32, 32);
//			loadEnemyType(2, 10, 2, new String[][]{ {"redb", "blub", "purb", "yelb", "orab", "greb"}, {"detb", "detb", "detb", "detb", "detb", "detb"} }, 64, 64);
//			loadEnemyType(1, 3, 1, new String[][]{ {"reds", "blus", null, "yels", null, null}, {"dets", "dets", null, "dets", null, null} }, 16, 16);
			
//			ScreenManager.get().addScreen("test1", new TestMenuScreen());
//			ScreenManager.get().addScreen("test2", new TestMenuScreen2());
			//ScreenManager.get().addScreen("mainmenuintro", new MainMenuIntroScreen());
			ScreenManager.get().addScreen("mainmenu", new MainMenuScreen());
			//ScreenManager.get().addScreen("game", new GameScreen());
			//ScreenManager.get().addScreen("highscore", new HighscoreScreen());
			ScreenManager.get().changeScreen("mainmenu");
		}
	}

}

package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class TestLoadScreen extends BasicScreen {
	
	public TestLoadScreen(){
		//this screen's texture has to be force loaded, or else it will error
		super(480, 800, new TextureRegion(AssetsManager.get().forceLoadTexture("data/load_bg.png"), 0, 0, 480, 800));
		Array<TextureRegion> regions = new Array<TextureRegion>();
		regions.add(new TextureRegion(AssetsManager.get().forceLoadTexture("data/loading_1.png"), 0, 0, 194, 247));
		regions.add(new TextureRegion(AssetsManager.get().forceLoadTexture("data/loading_2.png"), 0, 0, 194, 247));
		regions.add(new TextureRegion(AssetsManager.get().forceLoadTexture("data/loading_3.png"), 0, 0, 194, 247));
		myStage.addActor(new AnimationActor(new Animation(0.125f, regions), 240-97, 400-123));
		
	}
	
	public void show(){
		//this shit should get moved to class scope, will do later
		AssetsManager.get().loadTexture("data/mainropes.png");
		AssetsManager.get().loadTexture("data/menu_bg.png");
		AssetsManager.get().loadTexture("data/menu_exit_norm.png");
		AssetsManager.get().loadTexture("data/menu_exit_pressed.png");
		AssetsManager.get().loadTexture("data/menu_high_norm.png");
		AssetsManager.get().loadTexture("data/menu_high_pressed.png");
		AssetsManager.get().loadTexture("data/menu_in_norm.png");
		AssetsManager.get().loadTexture("data/menu_in_pressed.png");
		AssetsManager.get().loadTexture("data/menu_play_norm.png");
		AssetsManager.get().loadTexture("data/menu_play_pressed.png");
		AssetsManager.get().loadTexture("data/main_logo.png");
		AssetsManager.get().loadTexture("data/background_game.png");
		AssetsManager.get().loadTexture("data/Spuzzy_Regular_Spreadsheet.png");
		AssetsManager.get().loadTexture("data/high_mainbg.png");
		AssetsManager.get().loadTexture("data/high_mainbox.png");
		AssetsManager.get().loadTexture("data/high_menu.png");
		AssetsManager.get().loadTexture("data/high_maintitle.png");
		AssetsManager.get().loadTexture("data/high_numbers.png");

	}
	
	public void render(float delta){
		super.render(delta);
		if(AssetsManager.get().update()){
			//regions loading should ideally go in screen constructors, which will be called here
			//class scope bitch
			
//			loadEnemyType(1, 5, 1, new String[][]{ {"redm", "blum", null, "yelm", null, null}, {"detm", "detm", null, "detm", null, null} }, 32, 32);
//			loadEnemyType(2, 10, 2, new String[][]{ {"redb", "blub", "purb", "yelb", "orab", "greb"}, {"detb", "detb", "detb", "detb", "detb", "detb"} }, 64, 64);
//			loadEnemyType(1, 3, 1, new String[][]{ {"reds", "blus", null, "yels", null, null}, {"dets", "dets", null, "dets", null, null} }, 16, 16);
			
//			ScreenManager.get().addScreen("test1", new TestMenuScreen());
//			ScreenManager.get().addScreen("test2", new TestMenuScreen2());
			ScreenManager.get().addScreen("mainmenuintro", new MainMenuIntroScreen());
			ScreenManager.get().addScreen("mainmenu", new MainMenuScreen());
			ScreenManager.get().addScreen("game", new GameScreen());
			ScreenManager.get().addScreen("highscore", new HighscoreScreen());
			ScreenManager.get().changeScreen("mainmenuintro");
		}
	}

}

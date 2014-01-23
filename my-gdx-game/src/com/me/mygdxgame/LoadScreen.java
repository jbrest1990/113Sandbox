//package com.me.mygdxgame;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Animation;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.utils.Array;
//
//
//public class LoadScreen extends BasicScreen {
//	
//	private static final String[][] names = new String[][]{
//		{"MoveR", "MoveB", "MoveP", "MoveY", "MoveO", "MoveG"},
//		{"DeathR", "DeathB", "DeathP", "DeathY", "DeathO", "DeathG"},
//		{"AttackR", "AttackB", "AttackP", "AttackY", "AttackO", "AttackG"}
//	};
//	
//	public LoadScreen(){
//		super(480, 800, new TextureRegion(AssetsManager.get().forceLoadTexture("data/bestartever.png"), 0, 0, 256, 512));
//	}
//	
//	public void show(){
//		super.show();
//		//texture loading should go here
//		AssetsManager.get().loadTexture("data/programmerart.png");
//		AssetsManager.get().loadTexture("data/moreboxes.png");
//		AssetsManager.get().loadTexture("data/StartScreenFinal_v1.png");
//		AssetsManager.get().loadTexture("data/Rope.png");
//		AssetsManager.get().loadTexture("data/woodplates.png");
//	}
//	
//	public void render(float delta){
//		super.render(delta);
//		if(AssetsManager.get().update()){
//			//regions loading should go here, but can go anywhere after the textures are loaded
//			AssetsManager.get().loadTextureRegion("red", "data/programmerart.png", 0, 0, 256, 64);
//			AssetsManager.get().loadTextureRegion("green", "data/programmerart.png", 0, 64, 256, 64);
//			AssetsManager.get().loadTextureRegion("blue", "data/programmerart.png", 0, 128, 256, 64);
//			AssetsManager.get().loadTextureRegion("yellow", "data/programmerart.png", 0, 192, 256, 64);
//			AssetsManager.get().loadTextureRegion("backgroundmainmenu", "data/StartScreenFinal_v1.png", 0, 0, 480, 800);
//			AssetsManager.get().loadTextureRegion("ropes", "data/Rope.png", 0, 0, 200, 600);
//			AssetsManager.get().loadTextureRegion("boards", "data/woodplates.png", 0, 0, 278, 511);
//			
////			loadAnimation("data/moreboxes.png", "redm", 0, 0, 32, 32, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "blum", 32, 0, 32, 32, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "yelm", 96, 0, 32, 32, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "redb", 0, 32, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "blub", 64, 32, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "purb", 128, 32, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "yelb", 192, 32, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "orab", 0, 96, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "greb", 64, 96, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "reds", 0, 160, 16, 16, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "blus", 16, 160, 16, 16, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "yels", 48, 160, 16, 16, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "detm", 192, 0, 32, 32, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "detb", 128, 96, 64, 64, 1, 1.0f);
////			loadAnimation("data/moreboxes.png", "dets", 96, 160, 16, 16, 1, 1.0f);
//			
//			loadSpuzzies();
//			
////			loadEnemyType(1, 5, 1, new String[][]{ {"redm", "blum", null, "yelm", null, null}, {"detm", "detm", null, "detm", null, null} }, 32, 32);
////			loadEnemyType(2, 10, 2, new String[][]{ {"redb", "blub", "purb", "yelb", "orab", "greb"}, {"detb", "detb", "detb", "detb", "detb", "detb"} }, 64, 64);
////			loadEnemyType(1, 3, 1, new String[][]{ {"reds", "blus", null, "yels", null, null}, {"dets", "dets", null, "dets", null, null} }, 16, 16);
//			
////			ScreenManager.get().addScreen("test1", new TestMenuScreen());
////			ScreenManager.get().addScreen("test2", new TestMenuScreen2());
//			ScreenManager.get().addScreen("mainmenuintro", new MainMenuIntroScreen());
//			ScreenManager.get().addScreen("mainmenu", new MainMenuScreen());
////			ScreenManager.get().addScreen("game", new TestGameScreen());
//			ScreenManager.get().changeScreen("mainmenuintro");
//		}
//	}
//	
////	private void loadAnimation(String texture, String name, int startX, int startY, int width, int height, int frames, float duration){
////		Array<TextureRegion> regions = new Array<TextureRegion>();
////		Texture t = AssetsManager.get().getTexture(texture);
////		for(int i = 0; i < frames; i++){
////			regions.add(new TextureRegion(t, startX+width*i, startY, width, height));
////		}
////		AssetsManager.get().loadAnimation(name, duration, regions);
////	}
//	
//	private void loadEnemyType(int points, float speed, int damage, String basename){
//		AssetsManager.get().loadEnemyType(new EnemyType(speed, points, damage, loadAnimation(basename)));
//	}
//	
//	private Animation[][] loadAnimation(String basename){
//		Animation[][] animations = new Animation[3][6];
//		for(int i = 0; i < animations.length; i++){
//			for(int j = 0; j < animations[i].length; j++){
//				Texture text = AssetsManager.get().getTexture(basename+names[i][j]);
//				if(text!=null){
//					int frames = (i==0 ? 5 : 6);
//					Array<TextureRegion> regions = new Array<TextureRegion>();
//					for(int k = 0; k < frames; k++){
//						regions.add(new TextureRegion(text, k*text.getWidth()/frames, 0, text.getWidth()/frames, text.getHeight()));
//					}
//					animations[i][j] = new Animation(0.25f, regions);
//				}
//			}
//		}
//		return animations;
//	}
//	
//	//because screw everything else, why not hardcode?
//	private void loadSpuzzies(){
//		loadEnemyType(1, 5, 1, "Spuzzy_Regular_Spreadsheet");
//		loadEnemyType(2, 2.5f, 1, "Spuzzy_Speed_Spreadsheet");
//	}
//
//}

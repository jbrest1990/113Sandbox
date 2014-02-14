package com.me.cs133game;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.removeActor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.utils.Array;

public class GameScreen extends BasicScreen{
	
	protected Player myPlayer;
	
	private ArrayList<EnemyType> enemyData = new ArrayList<EnemyType>();
	
	public GameScreen(){
		super(512, 1024, AssetsManager.get().getRegion("gamebackground"));
		//super(480, 800, new TextureRegion(AssetsManager.get().getTexture("gamebackground"), 0, 0, 480, 800));
		//loadAnimation("spuzregmover", "data/Spuzzy_Regular_Spreadsheet.png", 0, 0, 128, 128, 5, 0.125f);
		
		//this could probably be class scope
		//TL;DR class scope
		//its going to be a common theme some day
		/*loadEnemyType(1, 5.0f, 1, 1, new String[][]{
				{"spuzregmover", "spuzregmoveb", null, "spuzregmovey", null, null},
				{"spuzregdeadr", "spuzregdeadb", null, "spuzregdeady", null, null}
		}, 128, 128);
		myPlayer = new Player(new PlayerType(10, 300));*/
	}
	
	public void show(){
		InputHandler.get().addListener(this);
	}
	
	public void hide(){
		InputHandler.get().removeListener(this);
	}

	@Override
	public boolean keyTyped(char character) {
		/*if(character==' '){
			System.out.println("this happened");
			int i = (int) (Math.random()*3)+1;
			TestEnemy t = new TestEnemy((i!=3 ? i : 4), enemyData.get(0));
			myStage.addActor(t);
			start(t, (int) (Math.random()*(myStage.getWidth()-t.getWidth())));
		}
		else if(character=='q'){
			myPlayer.currentColor = Color.RED;
			System.out.println("current color " + myPlayer.currentColor);
		}
		else if(character=='w'){
			myPlayer.currentColor = Color.BLUE;
			System.out.println("current color " + myPlayer.currentColor);
		}
		else if(character=='e'){
			myPlayer.currentColor = Color.YELLOW;
			System.out.println("current color " + myPlayer.currentColor);
		}
//		TestActor a = new TestActor();
//		myStage.addActor(a);
//		a.setPosition((float) (Math.random()*myStage.getWidth()), myStage.getHeight());
//		a.runMovement();
//		a.addListener(this);*/
		return false;
	}

	@Override
	public boolean handle(Event event) {
		System.out.println("event");
		if(event.getTarget() instanceof TestEnemy){
			if(event instanceof InputEvent && ((InputEvent) event).getType().equals(Type.touchDown)){
				((TestEnemy)event.getTarget()).onAttacked(myPlayer);
				return true;
			}
		}
		return false;
	}
	
	private class DamageRun implements Runnable{
		private final TestEnemy myEnemy;
		
		protected DamageRun(TestEnemy enemy){
			myEnemy = enemy;
		}
		
		public void run(){
			onDamage(myEnemy.myType.damage);
		}
	}
	
	private TestEnemy start(TestEnemy enemy, int x){
		enemy.setPosition(x, myStage.getHeight());
		enemy.addListener(this);
		enemy.addAction(sequence(moveTo(enemy.getX(), 0, enemy.myType.speed), 
				run(new DamageRun(enemy)),removeActor()));
		return enemy;
	}
	
	private void onDamage(int damage){
		if(myPlayer.damage(damage)){
			//do lose stuff here
		}
	}
	
	private void loadAnimation(String name, String texture, int startX, int startY, int width, int height, int frames, float duration){
		Array<TextureRegion> regions = new Array<TextureRegion>();
		Texture t = AssetsManager.get().getTexture(texture);
		for(int i = 0; i < frames; i++){
			regions.add(new TextureRegion(t, startX+width*i, startY, width, height));
		}
		AssetsManager.get().loadAnimation(name, duration, regions);
	}
	
	private void loadEnemyType(int health, float speed, int damage, int points, String[][] animations, int width, int height){
		EnemyType t = new EnemyType();
		t.health = health;
		t.speed = speed;
		t.damage = damage;
		t.points = points;
		t.animations = new Animation[animations.length][animations[0].length];
		for(int i = 0; i < animations.length; i++)
			for(int j = 0; j < animations[i].length; j++)
				t.animations[i][j] = (animations[i][j]!=null ? AssetsManager.get().getAnimation(animations[i][j]) : null);
		t.width = width;
		t.height = height;
		enemyData.add(t);
	}
	
	

}

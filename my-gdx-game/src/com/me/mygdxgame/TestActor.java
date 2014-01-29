package com.me.mygdxgame;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.removeActor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class TestActor extends Actor {
	
	private float timeAlive;
	private Animation animation;
	
	public TestActor(){
		animation = AssetsManager.get().getAnimation("boxes");
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){
		batch.draw(animation.getKeyFrame(timeAlive, true), getX(), getY());
	}
	
	public void runMovement(){
		addAction(sequence(moveTo(getX(), 0, 5), removeActor()));
	}
	
	public void act(float delta){
		super.act(delta);
		timeAlive+=delta;
//		Gdx.app.log("debug", "current num of actions to be run is " + this.getActions().size);
	}

}

package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AnimationActor extends Actor {
	
	private float timeAlive;
	private Animation myAnimation;
	
	public AnimationActor(Animation animation, float x, float y){
		myAnimation = animation;
		setPosition(x, y);
	}
	
	public void act(float delta){
		timeAlive+=delta;
	}
	
	public void draw(SpriteBatch b, float parentAlpha){
		b.draw(myAnimation.getKeyFrame(timeAlive, true), getX(), getY());
	}

}

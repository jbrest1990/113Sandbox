package com.me.cs133game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class TestEnemy extends Actor{
	
	private static final boolean[] doLoop = new boolean[]{
		true, false
	};
	
	private static final int ALIVE = 0;
	private static final int DEAD = 1;
	
	private float stateTime;
	private int myColor;
	public final EnemyType myType;
	private int state = ALIVE;
	
	public TestEnemy(int color, EnemyType type){
		myColor = color;
		myType = type;
		setWidth(type.width);
		setHeight(type.height);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){
		batch.draw(myType.animations[state][myColor-1].getKeyFrame(stateTime, doLoop[state]), getX(), getY(), getWidth(), getHeight());
	}
	
	public void act(float delta){
		super.act(delta);
		stateTime+=delta;
	}
	
	public void onAttacked(Player p){
		/*if((myColor&p.currentColor.value())==0)
		{
			p.onMiss();
			return;
		}
		if((myColor&(~p.currentColor.value()))==0)
			onDeath(p);
		else
			myColor&=(~p.currentColor.value());*/
	}
	
	public void onDeath(Player p){
		p.increaseScore(1);
		state = DEAD;
		clearActions();
		stateTime = 0;
		this.setTouchable(Touchable.disabled);
		addAction(sequence(delay(myType.animations[state][myColor-1].animationDuration + 0.125f), removeActor()));
	}

}

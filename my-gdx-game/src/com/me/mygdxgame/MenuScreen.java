package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuScreen extends BasicScreen implements EventListener, InputListener {
	
	public MenuScreen(){
		super();
	}
	
	public MenuScreen(TextureRegion background){
		super(background);
	}
	
	public MenuScreen(float x, float y){
		super(x, y);
	}
	
	public MenuScreen(float x, float y, TextureRegion background){
		super(x, y, background);
	}

	@Override
	public void resize(int width, int height) {
		

	}

	public void show(){
		InputHandler.get().addListener(this);
	}
	
	public void hide(){
		InputHandler.get().removeListener(this);
	}

	@Override
	public void pause() {
		

	}

	@Override
	public void resume() {
		

	}

	@Override
	public void dispose() {
		super.dispose();
	}
	
	public void addButton(Button b){
		myStage.addActor(b);
		b.addListener(this);
	}
	
	public void addButton(Button b, float x, float y){
		addButton(b);
		b.setPosition(x, y);
	}
	
	public Button addButton(TextureRegion up, TextureRegion down, float x, float y){
		Button b = new Button(new TextureRegionDrawable(up), new TextureRegionDrawable(down));
		addButton(b, x, y);
		return b;
	}

	@Override
	public boolean handle(Event event) {
		if(event.getTarget() instanceof Button){
			Button b = (Button) event.getTarget();
			if(event instanceof ChangeEvent){
				return buttonPressed(b);
			}
		}
		return false;
	}
	
	public boolean buttonPressed(Button b){
		return false;
	}

}

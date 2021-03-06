package com.me.mygdxgame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BasicScreen implements Screen, InputListener, EventListener{
	
	protected Stage myStage;
	
	protected TextureRegion myBackground;
	
	public BasicScreen(){
		myStage = new Stage();
	}
	
	public BasicScreen(TextureRegion background){
		this();
		myBackground = background;
		addBackground();
	}
	
	public BasicScreen(float x, float y){
		myStage = new Stage(x, y, false);
	}
	
	public BasicScreen(float x, float y, TextureRegion background){
		this(x, y);
		myBackground = background;
		addBackground();
	}

	@Override
	public void render(float delta) {
		myStage.act(delta);
		myStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void dispose() {
		myStage.dispose();
	}

	public boolean handle(Event event) {
		return false;
	}
	
	public boolean buttonPressed(Button b){
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return myStage.touchDown(screenX, screenY, pointer, button);
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return myStage.touchUp(screenX, screenY, pointer, button);
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return myStage.touchDragged(screenX, screenY, pointer);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
	/**
	 * clears the stage, but retains the background
	 */
	protected void clear(){
		myStage.clear();
		addBackground();
	}
	
	private void addBackground(){
		Image img = new Image(myBackground);
		img.setFillParent(true);
		myStage.addActor(img);
	}

}

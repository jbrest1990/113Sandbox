package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor{
	
	private static InputHandler handler = new InputHandler();
	
	public static InputHandler get(){
		return handler;
	}
	
	private ArrayList<InputListener> listeners = new ArrayList<InputListener>();
	
	private InputHandler(){
		
	}
	
	public void addListener(InputListener listener){
		listeners.add(listener);
	}
	
	public void removeListener(InputListener listener){
		listeners.remove(listener);
	}

	@Override
	public boolean keyDown(int keycode) {
		for(InputListener l : listeners){
			l.keyDown(keycode);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		for(InputListener l : listeners){
			l.keyUp(keycode);
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		for(InputListener l : listeners){
			l.keyTyped(character);
		}
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		for(InputListener l : listeners){
			l.touchDown(screenX, screenY, pointer, button);
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		for(InputListener l : listeners){
			l.touchUp(screenX, screenY, pointer, button);
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		for(InputListener l : listeners){
			l.touchDragged(screenX, screenY, pointer);
		}
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		for(InputListener l : listeners){
			l.mouseMoved(screenX, screenY);
		}
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		for(InputListener l : listeners){
			l.scrolled(amount);
		}
		return true;
	}
	
	

}

package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MyGdxGame implements ApplicationListener {
	
	@Override
	public void create() {		
		
		Gdx.input.setInputProcessor(InputHandler.get());
		
		// VVVVVV    Pretty much everything below this is testing    VVVVVV
		ScreenManager.get().addScreen("load", new TestLoadScreen());
	}

	@Override
	public void dispose() {
		ScreenManager.get().dispose();
		AssetsManager.get().dispose();
	}

	@Override
	public void render() {	
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		ScreenManager.get().getCurrentScreen().render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
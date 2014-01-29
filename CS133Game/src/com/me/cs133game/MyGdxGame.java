package com.me.cs133game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Texture tower;
	private Sprite sprite;
	private Sprite towerSprite;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/background.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//tower = new Texture(Gdx.files.internal("data/tower1.png"));
		//tower.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//int textureWidth = tower.getWidth();
		//int textureHeight = tower.getHeight();
		//float rotationAngle = 90f;
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 256);
		//TextureRegion region2 = new TextureRegion(tower, 0, 0, textureWidth, textureHeight);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);

	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {	
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		texture = new Texture(Gdx.files.internal("data/background.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		tower = new Texture(Gdx.files.internal("data/tower1.png"));
		tower.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		int textureWidth = tower.getWidth();
		int textureHeight = tower.getHeight();
		float rotationAngle = 90f;
		
		TextureRegion region2 = new TextureRegion(tower, 0, 0, textureWidth, textureHeight);
		towerSprite = new Sprite(region2);
		towerSprite.setSize(.15f,.15f);
		towerSprite.setOrigin(0, 0);
		towerSprite.setPosition(-towerSprite.getWidth()/2,-towerSprite.getHeight()/3);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		towerSprite.draw(batch);
		batch.end();
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

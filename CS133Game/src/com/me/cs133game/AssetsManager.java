package com.me.cs133game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AssetsManager {
	
	private static AssetsManager manager = new AssetsManager();
	
	public static AssetsManager get(){
		return manager;
	}
	
	private AssetsManager(){
		
	}
	
	public AssetManager assetManager = new AssetManager();
	
	private Map<String, Animation> animationsMap = new HashMap<String, Animation>();
	
	private Map<String, TextureRegion> regionsMap = new HashMap<String, TextureRegion>();
	
	public void loadTexture(String fileName){
		assetManager.load(fileName, Texture.class);
	}
	
	public Texture forceLoadTexture(String fileName){
		assetManager.load(fileName, Texture.class);
		finishLoading();
		return assetManager.get(fileName);
	}
	
	public Texture getTexture(String name){
		return assetManager.get(name, Texture.class);
	}
	
	public Animation loadAnimation(String name, float duration, Array<? extends TextureRegion> list){
		return loadAnimation(name, new Animation(duration, list));
	}
	
	public Animation loadAnimation(String name, float duration, TextureRegion...regions){
		return loadAnimation(name, new Animation(duration, regions));
	}
	
	public Animation loadAnimation(String name, Animation animation){
		animationsMap.put(name, animation);
		return animation;
	}
	
	public Animation loadAnimation(String name, float duration, String...regions){
		Array<TextureRegion> textregions = new Array<TextureRegion>();
		for(int i = 0; i < regions.length; i++){
			textregions.add(regionsMap.get(regions[i]));
		}
		return loadAnimation(name, duration, textregions);
	}
	
	public TextureRegion loadTextureRegion(String name, TextureRegion region){
		regionsMap.put(name, region);
		return region;
	}
	
	public TextureRegion loadTextureRegion(String name, Texture texture, int x, int y, int width, int height){
		return loadTextureRegion(name, new TextureRegion(texture, x, y, width, height));
	}
	
	public TextureRegion loadTextureRegion(String name, String texture, int x, int y, int width, int height){
		return loadTextureRegion(name, getTexture(texture), x, y, width, height);
	}
	
	public Animation getAnimation(String name){
		return animationsMap.get(name);
	}
	
	public TextureRegion getRegion(String name){
		return regionsMap.get(name);
	}
	
	public AssetManager getManager(){
		return assetManager;
	}
	
	public void dispose(){
		assetManager.dispose();
	}
	
	public float getProgress(){
		return assetManager.getProgress();
	}
	
	public boolean update(){
		return assetManager.update();
	}
	
	public void finishLoading(){
		assetManager.finishLoading();
	}

}

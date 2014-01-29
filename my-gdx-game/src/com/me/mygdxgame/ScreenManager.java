package com.me.mygdxgame;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Screen;

public class ScreenManager {
	
	private static ScreenManager theHandler = new ScreenManager();
	
	public static ScreenManager get(){
		return theHandler;
	}
	
	private Map<String, Screen> screenMap = new HashMap<String, Screen>();
	private String currentScreen;
	private String nextScreen;
	
	private ScreenManager(){
		
	}
	
	public void addScreen(String name, Screen screen){
		screenMap.put(name, screen);
		if(currentScreen==null)
			nextScreen = name;
	}
	
	public Screen getCurrentScreen(){
		if(!nextScreen.equals(currentScreen)){
			if(currentScreen!=null)
				screenMap.get(currentScreen).hide();
			screenMap.get(nextScreen).show();
			currentScreen = nextScreen;
		}
		return screenMap.get(currentScreen);
	}
	
	public void changeScreen(String screen){
		nextScreen = screen;
	}
	
	public void dispose(){
		for(String s : screenMap.keySet()){
			screenMap.get(s).dispose();
		}
	}

}

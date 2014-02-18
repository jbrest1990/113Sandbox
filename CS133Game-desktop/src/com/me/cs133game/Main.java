package com.me.cs133game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CS133Game";
		cfg.useGL20 = false;
		cfg.width = 1024;
		cfg.height = 512;
		
		new LwjglApplication(new MyGdxGame(), cfg);
	}
}

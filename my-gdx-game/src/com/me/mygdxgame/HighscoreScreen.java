package com.me.mygdxgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import com.badlogic.gdx.scenes.scene2d.ui.Button;


public class HighscoreScreen extends MenuScreen {
	
	private Button back;
	private String scores = "data/topScores";
	
	public HighscoreScreen(){
		super(480, 800, new TextureRegion(AssetsManager.get().forceLoadTexture("data/high_mainbg.png"), 0, 0, 480, 800));
		AssetsManager.get().loadTextureRegion("box", "data/high_mainbox.png", 0, 0, 398, 625);
		AssetsManager.get().loadTextureRegion("menu", "data/high_menu.png", 0, 0, 61, 36);
		AssetsManager.get().loadTextureRegion("title", "data/high_maintitle.png", 0, 0, 369, 57);
		AssetsManager.get().loadTextureRegion("spuzz", "data/loading_1.png", 0, 0, 194, 247);
		Actor a = new Image(AssetsManager.get().getRegion("box"));
		myStage.addActor(a);
		a.setPosition(41,87);
		a = new Image(AssetsManager.get().getRegion("spuzz"));
		myStage.addActor(a);
		a.setPosition(143, 226);
		a = new Image(AssetsManager.get().getRegion("title"));
		myStage.addActor(a);
		a.setPosition(55, 700);
		back = addButton(AssetsManager.get().getRegion("menu"), AssetsManager.get().getRegion("menu"), 20, 20);
	}
	
	public boolean buttonPressed(Button b){
		if(b.equals(back)){
			ScreenManager.get().changeScreen("mainmenu");
		}
		return false;
	}
	/*
	public void drawScore(){
		
		double [] highScores = readScores(new File (scores));
		
	 		int len = highScores.length;
	        int x = 0;
	        for (int i = 0; i < len; i++) {
	            char character = (char) highScores[i];
	    
	            if (character == ' ') {
	                x += 29;
	                continue;
	            }
	    
	            int srcX = 0;
	            int srcWidth = 0;
	            
	                srcX = (character - '0') * 29;
	                srcWidth = 20;
	            
	    
	            Sprite(AssetsManager.get().loadTextureRegion("9", "data/high_numbers.png", 0,0, 29, 31), x, 31, srcX, 0, srcWidth, 32);
	            x += srcWidth;
	        }
	        }*/
	        
	        public double [] readScores (File readMe){ 
	    		//Read in file and split string
	    		try{
	    			Scanner scan = new Scanner (readMe);
	    			double [] scores = new double [5];
	    			int i = 0;
	    			if( readMe == null )
	    				System.out.println( "File not found" );
	    			else{
	    				while(scan.hasNextLine() && i < 5){
	    					scores[i] = scan.nextInt();			
	    				}
	    			}
	    			return scores;
	    		}
	    		catch( FileNotFoundException e ){
	    			e.printStackTrace();
	    		}
	    		catch( IOException ioexception )
	    		{
	    			ioexception.printStackTrace( ); 
	    		}
	    		return null;
	    }
	}

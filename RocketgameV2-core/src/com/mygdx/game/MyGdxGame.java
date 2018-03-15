//Die ganze Klasse - Paul

package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import scenes.MainMenu;

public class MyGdxGame extends Game {
	
	private SpriteBatch batch;
	
	@Override
	public void create () { //erster Screen - Menu
		batch = new SpriteBatch();
		setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		
	}
	
	public SpriteBatch getBatch(){
		return this.batch;
		
	}
}

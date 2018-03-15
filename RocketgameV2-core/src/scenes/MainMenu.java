//Die ganze Klasse - Paul

package scenes;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

import helpers.GameInfo;

public class MainMenu implements Screen {
	
	private MyGdxGame game;
	
	private Texture bg;
	
	private Sprite startButton;
	
	public MainMenu(MyGdxGame game){
		this.game = game;
		bg = new Texture("1916x1080_SpaceRace_Background.jpg");
		startButton = new Sprite(new Texture("button-start-game.png"));
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		game.getBatch().begin();
		game.getBatch().draw(bg, 0, 0);
		game.getBatch().draw(startButton, GameInfo.WIDTH/4, GameInfo.HEIGHT/2);
		if(Gdx.input.equals(startButton) || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) //Recht einfache Lösung für einen StartButton
			game.setScreen(new MainGame(game));
		game.getBatch().end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

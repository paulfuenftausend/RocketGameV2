//Hauptsächlich Paul, mit Kanone und schießen zusammenhängend Robert

package scenes;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

import helpers.GameInfo;
import player.Actor;
import player.Cannon;
import player.Shot;
import player.Star;

public class MainGame implements Screen{
	
	private MyGdxGame game;
	
	private Sprite bgGame;
	
	private Actor actor;
	
	private Cannon cannon;
	
	private Star star;
	
	private int score;
	
	private String scoreName;
	
	private BitmapFont scoreFont;
	
	private int leben;
	
	private String lebenName;
	
	private BitmapFont lebenFont;
	
	private String cannonScoreName;
	
	private BitmapFont cannonScoreFont;

	
	

	
	public MainGame(MyGdxGame game){ //Constructor, wird in MainMenu gerufen
		this.game = game;
		bgGame = new Sprite(new Texture("2012-05-25 Virgo Haufen_DBE_ATWT_BN_CC_L_DONE_modified.jpg"));
		
		
		actor = new Actor("SpaceShip Sprite.png", GameInfo.WIDTH/2, GameInfo.HEIGHT/2);
		cannon = new Cannon("Turret Sprite.png", GameInfo.HEIGHT/2);
		star = new Star("SpaceGem Sprite.png");
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		score = 0;
		scoreName = "Space Gems: ";
		scoreFont = new BitmapFont();
		leben = 1;
		lebenName = "Leben: ";
		lebenFont = new BitmapFont();
		cannonScoreName = "Space Gems Cannon: ";
		cannonScoreFont = new BitmapFont();

	}

	@Override
	public void render(float delta) {
		
		game.getBatch().begin();
		game.getBatch().draw(bgGame, 0, 0);
		game.getBatch().draw(actor.sprite, actor.sprite.getX(), actor.sprite.getY());
		game.getBatch().draw(star, star.getX(), star.getY());
		scoreFont.setColor(1, 1, 1, 1);
		scoreFont.draw(game.getBatch(), scoreName+score, 0, GameInfo.HEIGHT- 20);
		lebenFont.setColor(1, 1, 1, 1);
		lebenFont.draw(game.getBatch(), lebenName+leben, 110, GameInfo.HEIGHT- 20);
		cannonScoreFont.setColor(1, 1, 1, 1);
		cannonScoreFont.draw(game.getBatch(), cannonScoreName+cannon.ScoreCannon(), 220, GameInfo.HEIGHT- 20 );
		actor.movement();
		if(actor.hitBox.overlaps(star.hitBox)){
			star.newPosition();
			score++;
			if(score>=20){
				game.setScreen(new Winner(game, "SpaceshipWin.png"));}
			}
		if(actor.bullets.size()>0){
			if(actor.hitBox.overlaps(actor.bullets.get(0).hitBox)){
				leben--;
				if(leben<=0)
					game.setScreen(new Winner(game, "CannonWin.png"));
				actor.bullets.remove(actor.bullets.get(0));
				}
		}
		if(actor.bullets.size()>0){
			if(star.hitBox.overlaps(actor.bullets.get(0).hitBox)){
				star.newPosition();
				cannon.score++;	
				actor.bullets.remove(actor.bullets.get(0));
			}	
		}
		game.getBatch().end();
		
		actor.update();
		actor.render();
		cannon.drehen();
		cannon.draw();
	
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

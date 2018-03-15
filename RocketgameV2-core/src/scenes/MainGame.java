package scenes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
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
	
	private World world;
	
	private Star star;
	
	private Shot shot;
	
	//Shooting
			ArrayList<Shot> bullets;
			Vector2 vector;
			float fireRate = 400000000;
			float lastShoot;
	
	public MainGame(MyGdxGame game){
		this.game = game;
		bgGame = new Sprite(new Texture("2012-05-25 Virgo Haufen_DBE_ATWT_BN_CC_L_DONE_modified.jpg"));
		world = new World(new Vector2(0, 0), true);			
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		actor = new Actor("SpaceShip Sprite.png", GameInfo.WIDTH/2, GameInfo.HEIGHT/2, world);
		cannon = new Cannon("Turret Sprite.png", GameInfo.HEIGHT/2);
		star = new Star("SpaceGem Sprite.png");
		//Array for bullets
				bullets = new ArrayList<Shot>();
				vector = new Vector2();
	}

	@Override
	public void render(float delta) {
		//Shooting code
				vector.set(1,0);
				vector.rotate(cannon.sprite.getRotation());
				vector.setLength(cannon.sprite.getWidth()*2);
				if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
					if(System.nanoTime()-lastShoot >= fireRate) {
						Shot bullet = new Shot("FireShotSprite.png", (0-(cannon.sprite.getWidth()/8))+vector.x,255+vector.y);
							
						bullet.setMovingDirection(cannon.sprite.getRotation(), (5*cannon.sprite.getWidth())/8);
						bullet.sprite.setRotation(cannon.sprite.getRotation());
						bullet.update(Gdx.graphics.getDeltaTime());
						bullets.add(bullet);
						lastShoot = System.nanoTime();
					}
				}
						
				//Update bullets
				for(Shot bullet : bullets){
					bullet.update(Gdx.graphics.getDeltaTime());
				}
		//actor.updateActor();
		
		game.getBatch().begin();
		game.getBatch().draw(bgGame, 0, 0);
		game.getBatch().draw(actor, actor.getX(), actor.getY());
		//game.getBatch().draw(cannon, cannon.getX(), cannon.getY());
		game.getBatch().draw(star, star.getX(), star.getY());
		actor.movement();
		cannon.drehen();
		cannon.draw();
		game.getBatch().end();
		
		//world.step(Gdx.graphics.getDeltaTime(), 6, 2);
		
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

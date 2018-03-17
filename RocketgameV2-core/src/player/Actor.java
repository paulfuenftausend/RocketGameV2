//Ganze Klasse - Paul

package player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Actor extends Sprite{
	int movementSpeed = 3;
	public Sprite sprite;
	public Rectangle hitBox;
	//Shooting
	ArrayList<Shot> bullets;
	Vector2 vector;
	float fireRate = 400000000;
	float lastShoot;
	
	public Actor(String texture, float x, float y){ //Konstruktor
		//super(new Texture(texture));
		
		sprite = new Sprite(new Texture(texture));
		sprite.setPosition(x - sprite.getWidth(), y - sprite.getHeight());
		hitBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		//Array for bullets
		bullets = new ArrayList<Shot>();
		vector = new Vector2();
	}
	
	public void movement() //Bewegung des Sprite
	{
		
		float ballMittelX = sprite.getX()+sprite.getWidth()/2;
		float ballObenY = sprite.getY()+sprite.getHeight();
		
		if((Gdx.input.getX()) != ballMittelX+movementSpeed || Gdx.input.getX() != ballMittelX-movementSpeed)
		{
			if((Gdx.input.getX()) > ballMittelX){
				sprite.translateX(movementSpeed);
			}else if((Gdx.input.getX()) < ballMittelX){
				sprite.translateX(-movementSpeed);
			}
		}
		
		if(-(Gdx.input.getY()+540) != ballObenY+movementSpeed || -(Gdx.input.getY()+550) != ballObenY-movementSpeed) 
		{
			if(-(Gdx.input.getY()-540) > ballObenY){
				sprite.translateY(movementSpeed);
			}else if(-(Gdx.input.getY()-540) < ballObenY){
				sprite.translateY(-movementSpeed);
			}
		}
		//Randbegrenzung
				if (sprite.getX() <= 0)
					sprite.translateX(movementSpeed);
				if (sprite.getX() >= 960-sprite.getWidth())
					sprite.translateX(-movementSpeed);	
				if (sprite.getY() <= 0)
					sprite.translateY(movementSpeed);
				if (sprite.getY() >= 540-sprite.getHeight())
					sprite.translateY(-movementSpeed);
		updateHitBox();
	}
	
	public void updateHitBox(){
		hitBox.setPosition(sprite.getX(), sprite.getY());
	}
	
	public void update()
	{
		
		//Shooting code
		vector.set(1,0);
		vector.rotate(Cannon.RotationDegrees());
		vector.setLength(Cannon.Width()*2);
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
				if(System.nanoTime()-lastShoot >= fireRate) {
					Shot bullet = new Shot("FireShotSprite.png", (0-(Cannon.Width()/8))+vector.x,255+vector.y);
									
					bullet.setMovingDirection(Cannon.RotationDegrees(), (5*Cannon.Width())/8);
					bullet.sprite.setRotation(Cannon.RotationDegrees());
					bullet.update(Gdx.graphics.getDeltaTime());
					bullets.add(bullet);
					lastShoot= System.nanoTime();
					System.out.println(Cannon.RotationDegrees()+ " " + Cannon.Width());
				}
		}	
		//Update bullets
		for(Shot bullet : bullets){
			bullet.update(Gdx.graphics.getDeltaTime());
			
		}
		
	}
	public void render()
	{
		
		for(Shot bullet : bullets){
			SpriteBatch batch = new SpriteBatch();
			batch.begin();
			bullet.sprite.draw(batch);
			batch.end();
		}
	}
	
	
}

//Shooting Robert, Rest Paul

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
	float movementSpeed = 3;

	public Sprite sprite;
	public Rectangle hitBox;
	//Shooting
	public ArrayList<Shot> bullets;
	public ArrayList<Shot> removeBullets;
	Vector2 vector;
	float fireRate = 400000000;
	float lastShoot;
	int powerUp = 0;
	float powerUpBegin;
	float powerUpTime = 999999999;
	
	public Actor(String texture, float x, float y){ //Konstruktor
		sprite = new Sprite(new Texture(texture));
		sprite.setPosition(x - sprite.getWidth(), y - sprite.getHeight());
		hitBox = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		//Array for bullets
		bullets = new ArrayList<Shot>();
		removeBullets = new ArrayList<Shot>();
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
				if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
					if(Cannon.ScoreCannon() >= 20){
						powerUp = 1;
						powerUpBegin = System.nanoTime();
						Cannon.score= Cannon.score -20; 
					}	
				}
				else if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
					if(Cannon.ScoreCannon() >= 20){
						fireRate = 300000000;
						powerUpBegin = System.nanoTime();
						Cannon.score= Cannon.score -20;
					}	
				}
				else {
					if(System.nanoTime() - powerUpBegin >= powerUpTime ) {
						powerUp = 0;
						fireRate = 400000000;
					}	
					
				}
						
				vector.set(1,0);
				vector.rotate(Cannon.RotationDegrees());
				vector.setLength(Cannon.Width()*2);
				if(Gdx.input.isKeyPressed(Keys.SPACE)){
					switch(powerUp) {
					case 0:
						if(System.nanoTime()-lastShoot >= fireRate) {
							Shot bullet = new Shot("FireShotSprite.png",(0-(Cannon.Width()/8))+vector.x,255+vector.y);
									
							bullet.setMovingDirection(Cannon.RotationDegrees(), (5*Cannon.Width())/8);
							bullet.sprite.setRotation(Cannon.RotationDegrees());
							bullet.update(Gdx.graphics.getDeltaTime());
							bullets.add(bullet);
							lastShoot= System.nanoTime();
						}
							break;
					case 1:
						if(System.nanoTime()-lastShoot >= fireRate) {
							Shot bullet = new Shot("FireShotSprite.png",(0-(Cannon.Width()/8))+vector.x,255+vector.y);
									
							bullet.setMovingDirection(Cannon.RotationDegrees(), (5*Cannon.Width())/8);
							bullet.sprite.setRotation(Cannon.RotationDegrees());
							bullet.update(Gdx.graphics.getDeltaTime());
							bullets.add(bullet);
									
							Shot bullet1 = new Shot("FireShotSprite.png",(0-(Cannon.Width()/8))+vector.x,255+vector.y);
							
							bullet1.setMovingDirection(Cannon.RotationDegrees()+10, (5*Cannon.Width())/8);
							bullet1.sprite.setRotation(Cannon.RotationDegrees()+10);
							bullet1.update(Gdx.graphics.getDeltaTime()+10);
							bullets.add(bullet1);
									
							Shot bullet2 = new Shot("FireShotSprite.png",(0-(Cannon.Width()/8))+vector.x,255+vector.y);
									
							bullet2.setMovingDirection(Cannon.RotationDegrees()-10, (5*Cannon.Width())/8);
							bullet2.sprite.setRotation(Cannon.RotationDegrees()-10);
							bullet2.update(Gdx.graphics.getDeltaTime());
							bullets.add(bullet2);
							lastShoot= System.nanoTime();
							break;
					}
					}
				}
						
								
				//Update and remove bullets
				for(Shot bullet : bullets){
					if(bullet.remove == true) {
						removeBullets.add(bullet);
					}
					else {
						bullet.update(Gdx.graphics.getDeltaTime());
						
					}
				}
				bullets.removeAll(removeBullets);
				removeBullets.clear();
				System.out.println(removeBullets);
			}
	public void render()
	{
		
		for(Shot bullet : bullets){
			SpriteBatch batch = new SpriteBatch();
			batch.begin();
			bullet.sprite.draw(batch);
			bullet.updateHitBox();
			batch.end();
		}
	}
	
	
}

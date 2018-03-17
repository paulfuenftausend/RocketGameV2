//Ganze Klasse - Paul

package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Actor extends Sprite{
	float movementSpeed = 3;
	
	public Rectangle hitBox;
	
	public Actor(String texture, float x, float y){ //Konstruktor
		super(new Texture(texture));
		setPosition(x - getWidth(), y - getHeight());
		hitBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	public void movement() //Bewegung des Sprite
	{
		
		float ballMittelX = getX()+getWidth()/2;
		float ballObenY = getY()+getHeight();
		
		if((Gdx.input.getX()) != ballMittelX+movementSpeed || Gdx.input.getX() != ballMittelX-movementSpeed)
		{
			if((Gdx.input.getX()) > ballMittelX){
				translateX(movementSpeed);
			}else if((Gdx.input.getX()) < ballMittelX){
				translateX(-movementSpeed);
			}
		}
		
		if(-(Gdx.input.getY()+540) != ballObenY+movementSpeed || -(Gdx.input.getY()+550) != ballObenY-movementSpeed) 
		{
			if(-(Gdx.input.getY()-540) > ballObenY){
				translateY(movementSpeed);
			}else if(-(Gdx.input.getY()-540) < ballObenY){
				translateY(-movementSpeed);
			}
		}
		//Randbegrenzung
				if (getX() <= 0)
					translateX(movementSpeed);
				if (getX() >= 960-getWidth())
					translateX(-movementSpeed);	
				if (getY() <= 0)
					translateY(movementSpeed);
				if (getY() >= 540-getHeight())
					translateY(-movementSpeed);
		updateHitBox();
	}
	
	public void updateHitBox(){
		hitBox.setPosition(getX(), getY());
	}
	
	
}

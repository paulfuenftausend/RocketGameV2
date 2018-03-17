//Klasse bis auf Physik von Robert, Physik von Paul

package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Shot extends Sprite{
	
	Vector2 direction;
	float x,y;
	public Sprite sprite;
	public static Rectangle hitBox;

	public Shot(String texture, float x, float y){
		sprite = new Sprite(new Texture(texture));
		hitBox = new Rectangle(sprite.getX(), sprite.getY(), sprite.getHeight()/2, sprite.getWidth());
		
		this.x = x;
		this.y = y;
		sprite.setPosition(x, y);
		
	}
	
	
	public void setMovingDirection(float rotationDegrees, float length){
		direction = new Vector2();
		direction.set(1, 0);
		direction.rotate(rotationDegrees);
		direction.setLength(length);
	}
	public void update(float deltaTime){
		x += direction.x*deltaTime;
		y += direction.y*deltaTime;
		sprite.setPosition(x, y);
	}
	public void updateHitBox(){
		hitBox.setPosition(sprite.getX(), sprite.getY());
	}
}

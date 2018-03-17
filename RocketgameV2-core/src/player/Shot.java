//Klasse bis auf Physik von Robert, Physik von Paul

package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Shot extends Sprite{
	
	Vector2 direction;
	float x,y;
	public Sprite sprite;

	public Shot(String texture, float x, float y){
		sprite = new Sprite(new Texture(texture));
		
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
}

package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Cannon extends Sprite {

	public Sprite sprite;

	public Cannon(String texture, float y){
		//super(new Texture(texture));
		sprite = new Sprite(new Texture(texture));
		
		sprite.setPosition(0-sprite.getWidth()/2, y - sprite.getHeight()/2);
		sprite.setOrigin(sprite.getOriginX()-(getWidth()/8), sprite.getOriginY());
		sprite.setScale(4);
		
		
		
	}	
	
	public void drehen()
	{
			if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				if(sprite.getRotation()<77f) {
					sprite.rotate(2f);
				}
			}
			
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				if(sprite.getRotation()>-77f) {
					sprite.rotate(-2f);
				}	
			}
			if (Gdx.input.isKeyPressed(Input.Keys.I))
				System.out.println(getX() + " " + getY()+ " " + getRotation());
			
			
		}
	
	public void draw(){
		SpriteBatch batch = new SpriteBatch();
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
}


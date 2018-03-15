package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Cannon extends Sprite {


	public Cannon(String texture, float y){
		super(new Texture(texture));
		
		setPosition(0-getWidth()/2, y - getHeight()/2);
		setOrigin(getOriginX()-(getWidth()/8), getOriginY());
	}	
	
	public void drehen()
	{
			if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				if(getRotation()<77f) {
					rotate(2f);
				}
			}
			
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				if(getRotation()>-77f) {
					rotate(-2f);
				}	
			}
			if (Gdx.input.isKeyPressed(Input.Keys.I))
				System.out.println(getX() + " " + getY()+ " " + getRotation());
			
			
		}
}




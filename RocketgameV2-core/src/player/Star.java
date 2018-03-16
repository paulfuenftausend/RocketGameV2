//Klasse - Paul

package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import helpers.GameInfo;

public class Star extends Sprite{
	public Rectangle hitBox;

	public Star(String texture){ //Konstruktor
		super(new Texture(texture));
		setPosition(MathUtils.random(GameInfo.WIDTH), MathUtils.random(GameInfo.HEIGHT));
		hitBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	public void newPosition(){
		setPosition(MathUtils.random(GameInfo.WIDTH)-getWidth()/2, MathUtils.random(GameInfo.HEIGHT)-getHeight()/2);
		hitBox.setPosition(getX(), getY());
	}
}

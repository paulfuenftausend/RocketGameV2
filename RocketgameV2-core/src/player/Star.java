package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

import helpers.GameInfo;

public class Star extends Sprite{

	public Star(String texture){
		super(new Texture(texture));
		setPosition(MathUtils.random(GameInfo.WIDTH), MathUtils.random(GameInfo.HEIGHT));
		setScale(2);
	}
}

package player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Actor extends Sprite{
	int movementSpeed = 3;

	private World world;
	public Body body;
	
	public Actor(String texture, float x, float y, World world){
		super(new Texture(texture));
		this.world = world;
		setPosition(x - getWidth(), y - getHeight());
		physischerKoerper();
	}
	
	
	public void physischerKoerper() //erstellung eines Physischen Körpers um Berührung zu registrieren
	{
		BodyDef bodyDef = new BodyDef();
		
		bodyDef.type = BodyDef.BodyType.DynamicBody; //von allen Kräften beeinflusst (Gravitation, schieben, ziehen...)
		bodyDef.position.set(getX(), getY()); //Körper an die selbe Stelle wie Textur legen
		
		body = world.createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(getWidth()/2, getHeight()/2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1;
		
		body.createFixture(fixtureDef);
		shape.dispose();
	}
	
	public void updateActor(){
		this.setPosition(body.getPosition().x, body.getPosition().y);
	}
	
	
	public void move(){
		if(body.getPosition().x != Gdx.input.getX()){
			if(body.getPosition().x > Gdx.input.getX()){
				body.applyLinearImpulse(new Vector2(-movementSpeed, 0), new Vector2(body.getWorldCenter()), true);
			}else if(body.getPosition().x < Gdx.input.getX()){
				body.applyLinearImpulse(new Vector2(-movementSpeed, 0), new Vector2(body.getWorldCenter()), true);
			}
		}
		if(body.getLocalCenter().y != Gdx.input.getY()){
			if(body.getLocalCenter().y > Gdx.input.getY()){
				body.applyForceToCenter(0, -movementSpeed, true);
			}else if(body.getLocalCenter().y < Gdx.input.getY()){
				body.applyForceToCenter(0, movementSpeed, true);
			}
		}
	}
	
	public void movement()
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
	}
}

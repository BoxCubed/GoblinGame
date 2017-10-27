
package tech.boxcubed.goblingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import tech.boxcubed.goblingame.BoxoUtil;
import tech.boxcubed.goblingame.GoblinGame;
import tech.boxcubed.goblingame.assets.Asset;

public class GameScreen implements Screen{
	
	private GoblinGame game;
	private OrthographicCamera cam;
	private World world;
	private float animationDelta;

	private Animation<TextureRegion> goblinWalkAnim;
	private Sprite goblinSprite;
	private Body goblinBody;
	private Body floorBody;
	private Box2DDebugRenderer boxRenderer;



	
	public GameScreen(GoblinGame game){
		this.game=game;
		goblinWalkAnim= new Animation<>(1/10f, BoxoUtil.toTextureRegionArray(game.getAssetManager().getAsset(Asset.GOBLIN_SHEET), 4, 4));
		world=new World(new Vector2(0f,-0.8f),true);
		boxRenderer=new Box2DDebugRenderer();
		goblinSprite=new Sprite(goblinWalkAnim.getKeyFrame(0,false).getTexture(),100,100);
		//test body
		BodyDef def=new BodyDef();
		def.position.set(0,1);
		def.type= BodyDef.BodyType.DynamicBody;
		goblinBody=world.createBody(def);
		PolygonShape shape=new PolygonShape();
		shape.setAsBox(0.5f,1);
		FixtureDef fdef=new FixtureDef();
		fdef.shape=shape;
		goblinBody.createFixture(fdef);

		def.type= BodyDef.BodyType.StaticBody;
		def.position.set(0,0);
		floorBody=world.createBody(def);
		shape.setAsBox(50,1);
		fdef.shape=shape;
		floorBody.createFixture(fdef);








	}


	@Override
	public void show() {
		game.getLogger().info("Game screen shown");

		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		animationDelta +=delta;
		cam.update();
		world.step(delta,100,100);
		game.getBatch().setProjectionMatrix(cam.combined);
		game.getBatch().begin();
		//game.getBatch().draw(game.getAssetManager().getAsset(Asset.BADLOGIC),0,0);
		goblinSprite.setRegion(goblinWalkAnim.getKeyFrame(animationDelta,true));
		goblinSprite.setPosition(goblinBody.getPosition().x*GoblinGame.PPM-1f*GoblinGame.PPM,goblinBody.getPosition().y*GoblinGame.PPM-1f*GoblinGame.PPM);
		goblinSprite.draw(game.getBatch());
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			//cam.position.x-=500*delta;
			goblinBody.setLinearVelocity(5,0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A))
			goblinBody.setLinearVelocity(-5,0);
		if(Gdx.input.isKeyPressed(Input.Keys.W))
			goblinBody.setLinearVelocity(0,4);
		if(Gdx.input.isKeyPressed(Input.Keys.S))
			goblinBody.setLinearVelocity(0,-5);
		//game.getLogger().info(cam.position.x+" "+cam.position.y);




		game.getBatch().end();
		boxRenderer.render(world,cam.combined);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		cam=new OrthographicCamera(width,height);
		cam.position.x+=width/2;
		cam.position.y+=height/2;
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

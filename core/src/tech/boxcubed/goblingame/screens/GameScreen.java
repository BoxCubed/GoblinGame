
package tech.boxcubed.goblingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Affine2;
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


	
	public GameScreen(GoblinGame game){
		this.game=game;
		goblinWalkAnim= new Animation<>(1/10f, BoxoUtil.toTextureRegionArray(game.getAssetManager().getAsset(Asset.GOBLIN_SHEET), 4, 4));




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
		game.getBatch().setProjectionMatrix(cam.combined);
		game.getBatch().begin();
		//game.getBatch().draw(game.getAssetManager().getAsset(Asset.BADLOGIC),0,0);
		game.getBatch().draw(goblinWalkAnim.getKeyFrame(animationDelta,true),100,0,-100,100);
		if(Gdx.input.isKeyPressed(Input.Keys.D))
			cam.position.x-=500*delta;
		if(Gdx.input.isKeyPressed(Input.Keys.A))
			cam.position.x+=500*delta;
		if(Gdx.input.isKeyPressed(Input.Keys.W))
			cam.position.y-=500*delta;
		if(Gdx.input.isKeyPressed(Input.Keys.S))
			cam.position.y+=500*delta;
		//game.getLogger().info(cam.position.x+" "+cam.position.y);



		game.getBatch().end();

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

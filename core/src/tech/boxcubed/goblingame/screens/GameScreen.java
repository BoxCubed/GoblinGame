
package tech.boxcubed.goblingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import tech.boxcubed.goblingame.BoxoUtil;
import tech.boxcubed.goblingame.GoblinGame;
import tech.boxcubed.goblingame.assets.Asset;

public class GameScreen implements Screen{
	
	private GoblinGame game;
	private OrthographicCamera cam;
	private World world;
	private float delta;

	private Animation<TextureRegion> goblinWalkAnim;


	
	public GameScreen(GoblinGame game){
		this.game=game;
		goblinWalkAnim= new Animation<>(1/10f, BoxoUtil.toTextureRegionArray(game.getAssetManager().getAsset(Asset.GOBLIN_SHEET), 4, 4));




	}


	@Override
	public void show() {
		cam=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		this.delta+=delta;
		game.getBatch().setProjectionMatrix(cam.combined);
		game.getBatch().begin();
		//game.getBatch().draw(game.getAssetManager().getAsset(Asset.BADLOGIC),0,0);
		game.getBatch().draw(goblinWalkAnim.getKeyFrame(this.delta,true),-200,-200);
		game.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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

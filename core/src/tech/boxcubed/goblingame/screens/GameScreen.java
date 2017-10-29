
package tech.boxcubed.goblingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import tech.boxcubed.goblingame.GoblinGame;
import tech.boxcubed.goblingame.objects.Floor;
import tech.boxcubed.goblingame.objects.Goblin;

public class GameScreen implements Screen{
	
	private GoblinGame game;
	private OrthographicCamera cam;
	private World world;


	private Goblin goblin;
	private Floor floor;

	private Box2DDebugRenderer boxRenderer;



	
	public GameScreen(GoblinGame game){
		this.game=game;
		world=new World(new Vector2(0f,-14),true);
		boxRenderer=new Box2DDebugRenderer();

		goblin=new Goblin(game,world,new Vector2(0.5f,2f));
		floor=new Floor(world, game);






	}


	@Override
	public void show() {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		cam.update();
		world.step(delta,6,2);
		game.getBatch().setProjectionMatrix(cam.combined);
		game.getBatch().begin();


		goblin.render(delta);
		floor.render(delta);

		//game.getLogger().info(cam.position.x+" "+cam.position.y);




		game.getBatch().end();
		boxRenderer.render(world,cam.combined.cpy().scl(GoblinGame.PPM));
		//boxRenderer.render(world,cam.combined.cpy().translate(50, Gdx.graphics.getHeight()-300,0).scl(10));
		//TODO minimap
	}

	@Override
	public void resize(int width, int height) {
		game.getLogger().info("resized to "+width+"x"+height);

		cam=new OrthographicCamera(width,height);
		cam.position.x+=width/2;
		cam.position.y+=height/2;
		
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

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

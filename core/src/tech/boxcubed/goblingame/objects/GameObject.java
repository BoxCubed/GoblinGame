package tech.boxcubed.goblingame.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import tech.boxcubed.goblingame.GoblinGame;

/**
 * Created by SimplyBallistic on 27/10/2017.
 *
 * @author SimplyBallistic
 */
public abstract class GameObject {
    private Body body;
    private Fixture fixture;
    private World world;
    protected GoblinGame game;


    public GameObject(World world, GoblinGame game){
        this.world=world;
        this.game = game;
    }
    public void createObject(FixtureDef fdef,BodyDef bdef){
        body=world.createBody(bdef);
        fixture=body.createFixture(fdef);





    }
    public abstract void render(float delta);

    public Body getBody() {
        return body;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public World getWorld() {
        return world;
    }
}

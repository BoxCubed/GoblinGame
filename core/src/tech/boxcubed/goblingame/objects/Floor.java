package tech.boxcubed.goblingame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import tech.boxcubed.goblingame.GoblinGame;

/**
 * Created by SimplyBallistic on 27/10/2017.
 *
 * @author SimplyBallistic
 */
public class Floor extends GameObject {
    public Floor(World world, GoblinGame game) {
        super(world, game);
        BodyDef def=new BodyDef();
        FixtureDef fdef=new FixtureDef();
        PolygonShape shape=new PolygonShape();
        shape.setAsBox(50,1);
        def.position.set(0,0);
        fdef.shape=shape;

        createObject(fdef,def);
        shape.dispose();
    }

    @Override
    public void render(float delta) {

    }
}

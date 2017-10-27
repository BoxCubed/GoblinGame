package tech.boxcubed.goblingame.objects;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by SimplyBallistic on 27/10/2017.
 *
 * @author SimplyBallistic
 */
public class Goblin extends GameObject {
    public Goblin(World world) {
        super(world);
        FixtureDef fixtureDef=new FixtureDef();
        PolygonShape shape=new PolygonShape();
        shape.setAsBox(0.5f,0.8f);
        fixtureDef.shape=shape;
        shape.dispose();
        

        createObject();
    }

    @Override
    public void render(float delta) {

    }
}

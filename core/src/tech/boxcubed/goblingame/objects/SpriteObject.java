package tech.boxcubed.goblingame.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import tech.boxcubed.goblingame.GoblinGame;

/**
 * Created by SimplyBallistic on 27/10/2017.
 *
 * @author SimplyBallistic
 */
public abstract class SpriteObject extends GameObject {
    private Sprite sprite;
    public SpriteObject(World world, GoblinGame game) {
        super(world, game);

    }
    public void createObject(Texture texture,FixtureDef fdef,BodyDef bdef){
        createObject(fdef,bdef);
        sprite=new Sprite(texture);


    }
    @Override
    public void createObject(FixtureDef fdef, BodyDef bdef) {
        super.createObject(fdef, bdef);
    }

    @Override
    public void render(float delta) {
        getSprite().setPosition(getBody().getPosition().x*GoblinGame.PPM,getBody().getPosition().y*GoblinGame.PPM);
        update(delta);
        getSprite().draw(game.getBatch());


    }
    public abstract void update(float delta);
    public Sprite getSprite() {
        return sprite;
    }
}

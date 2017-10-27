package tech.boxcubed.goblingame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import tech.boxcubed.goblingame.BoxoUtil;
import tech.boxcubed.goblingame.GoblinGame;
import tech.boxcubed.goblingame.assets.Asset;


/**
 * Created by SimplyBallistic on 27/10/2017.
 *
 * @author SimplyBallistic
 */
public class Goblin extends SpriteObject {
    private Animation<TextureRegion> walkAnim;
    private float animationDelta;
    public Goblin(GoblinGame game,World world, Vector2 pos) {
        super(world,game);
        walkAnim= new Animation<>(1 / 10f, BoxoUtil.toTextureRegionArray(game.getAssetManager().getAsset(Asset.GOBLIN_SHEET), 4, 4));



        FixtureDef fixtureDef=new FixtureDef();
        PolygonShape shape=new PolygonShape();
        shape.setAsBox(0.5f,0.8f);
        fixtureDef.shape=shape;
        BodyDef bdef=new BodyDef();
        bdef.type= BodyDef.BodyType.DynamicBody;
        bdef.position.set(pos.x,pos.y);


        createObject(walkAnim.getKeyFrame(0,false).getTexture(),fixtureDef,bdef);
        shape.dispose();

    }



    @Override
    public void update(float delta) {
        animationDelta+=delta;
        getSprite().setRegion(walkAnim.getKeyFrame(animationDelta,true));
        getSprite().setSize(100,100);
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            //cam.position.x-=500*delta;
            getBody().setLinearVelocity(5,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            getBody().setLinearVelocity(-5,0);
        if(Gdx.input.isKeyPressed(Input.Keys.W))
            getBody().setLinearVelocity(0,4);
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            getBody().setLinearVelocity(0,-5);

    }
}

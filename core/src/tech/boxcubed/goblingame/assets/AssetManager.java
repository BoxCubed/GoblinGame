package tech.boxcubed.goblingame.assets;

import tech.boxcubed.goblingame.GoblinGame;

import java.lang.reflect.Field;

/**
 * Created by SimplyBallistic on 24/10/2017.
 *
 * @author SimplyBallistic
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {


    private GoblinGame game;

    public AssetManager(GoblinGame game) throws IllegalAccessException {
        super();
        this.game = game;
        for (Field field : Asset.class.getFields()) {
            if(field.getType().getName().equals(Asset.class.getName())){
                Asset<?> asset= (Asset<?>) field.get(null);
                game.getLogger().info("Loading asset: "+asset.getPath());
                load(asset.getPath(),asset.getType());

            }
        }

    }





    public <T> T getAsset(Asset<T> asset){

        return get(asset.getPath(), asset.getType());


    }

}

package tech.boxcubed.goblingame.assets;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.lang.reflect.Field;

/**
 * Created by SimplyBallistic on 24/10/2017.
 *
 * @author SimplyBallistic
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {




    public AssetManager() throws IllegalAccessException {
        super();
        setLoader(Animation.class,new AnimationLoader(getFileHandleResolver()));
        for (Field field : Asset.class.getFields()) {
            if(field.getType().getName().equals(Asset.class.getName())){
                Asset asset= (Asset) field.get(null);
                if(field.getGenericType().getTypeName().equals("Animation")){
                    load(asset.getPath().replaceAll(":anim",""), TextureAtlas.class);
                    load(asset.getPath(),Animation.class,new AnimationLoader.AnimationPrefs(1f/asset.getDuration()));


                }
                else
                load(asset.getPath(),asset.getType());
            }
        }

    }





    public <T> T getAsset(Asset<T> asset){

        return get(asset.getPath(), asset.getType());


    }

}

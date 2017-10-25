package tech.boxcubed.goblingame.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
/**
 * A basic Animation loader
 *
 * @author ryan9
 *
 */
@SuppressWarnings("rawtypes")
public class AnimationLoader extends SynchronousAssetLoader<Animation, AnimationLoader.AnimationPrefs>{






    public AnimationLoader(FileHandleResolver resolver) {
        super(resolver);
        // TODO Auto-generated constructor stub
    }


    public static class AnimationPrefs extends AssetLoaderParameters<Animation>{
        float duration =1f/30f*100;
        PlayMode mode=PlayMode.NORMAL;

        public AnimationPrefs(float duration) {
            this.duration = duration;
        }

        /**
         *
         * Utility Method to return new instance without memory attachment
         * @return
         */

        public AnimationPrefs cpy(){
            AnimationPrefs cpy=new AnimationPrefs(duration);
            cpy.mode=mode;
            return cpy;
        }


    }



    @Override
    public Animation load(AssetManager manager, String fileName, FileHandle file, AnimationPrefs parameter) {
        fileName=fileName.replaceAll(":anim", "");
        if(parameter!=null)
            return new Animation<>(parameter.duration, manager.get(fileName, TextureAtlas.class).getRegions(), parameter.mode);
        else{

            return new Animation<>(1f/30f*100, manager.get(fileName, TextureAtlas.class).getRegions());}


    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AnimationPrefs param) {
        Array<AssetDescriptor> deps = new Array<>();
        if (param != null) {
            deps = new Array<>();
            deps.add(new AssetDescriptor<>(file.path(), TextureAtlas.class));
        }
        return deps;
    }

}

package tech.boxcubed.goblingame.assets;

import com.badlogic.gdx.graphics.Texture;
import javafx.animation.Animation;

/**
 * Created by SimplyBallistic on 26/10/2017.
 *
 * @author SimplyBallistic
 */
public class Asset<T> {
    private String path;
    private Class clazz;
    private float duration=16;

    //public static final Asset<Animation> GOBLIN_ANIM=new Asset<>("anim/goblinAnim.atlas",Animation.class,30);
    public static final Asset<Texture> BADLOGIC=new Asset<>("badlogic.jpg",Texture.class);

    private Asset(String path, Class<? extends T> clazz) {

        this.path = path;
        this.clazz = clazz;
    }
    private Asset(String path,Class<? extends T> clazz,float duration){
        this(path+":anim",clazz);


        this.duration=duration;


    }

    public String getPath() {
        return path;
    }

    public Class<? extends T> getType() {
        return clazz;
    }

    public float getDuration() {
        return duration;
    }
}

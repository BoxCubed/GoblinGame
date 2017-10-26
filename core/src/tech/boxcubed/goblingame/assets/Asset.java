package tech.boxcubed.goblingame.assets;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by SimplyBallistic on 26/10/2017.
 *
 * @author SimplyBallistic
 */
public class Asset<T> {
    private String path;
    private Class<? extends T> clazz;

    //public static final Asset<Animation> GOBLIN_ANIM=new Asset<>("anim/goblinAnim.atlas",Animation.class,30);
    public static final Asset<Texture> BADLOGIC=new Asset<>("badlogic.jpg",Texture.class);
    public static final Asset<Texture> GOBLIN_SHEET=new Asset<>("goblin-sheet.png",Texture.class);

    private Asset(String path, Class<? extends T> clazz) {

        this.path = path;
        this.clazz = clazz;
    }

    public String getPath() {
        return path;
    }

    public Class<? extends T> getType() {
        return clazz;
    }

}

package tech.boxcubed.goblingame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import tech.boxcubed.goblingame.GoblinGameMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GoblinGameMain(), config);
		
		config.resizable=true;
		config.height=768;
		config.width=1366;
	}
}

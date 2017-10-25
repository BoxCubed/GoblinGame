package tech.boxcubed.goblingame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import tech.boxcubed.goblingame.GoblinGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GoblinGame(), config);
		
		config.resizable=true;
		config.height=768;
		config.width=1366;
	}
}

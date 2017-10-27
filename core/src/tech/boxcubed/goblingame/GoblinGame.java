package tech.boxcubed.goblingame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tech.boxcubed.goblingame.assets.AssetManager;
import tech.boxcubed.goblingame.screens.GameScreen;

import java.util.Calendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class GoblinGame extends Game {
	private SpriteBatch batch;
	private Logger logger;
	public static final int PPM=50;
	private AssetManager assetManager;
	public static boolean DEBUG=true;


	public GoblinGame() {
		logger=Logger.getLogger("GoblinGame");

		for (Handler handler : logger.getParent().getHandlers()) {
			logger.getParent().removeHandler(handler);
		}

		ConsoleHandler handler=new ConsoleHandler();
		handler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record) {
				Calendar cal=Calendar.getInstance();
				cal.setTimeInMillis(record.getMillis());
				return "["+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND)+"] - "+record.getLevel()+": "+record.getMessage()+"\n";

			}
		});

		logger.addHandler(handler);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		BoxoUtil.reset();
		logger.info("Starting Goblin Game...");
		try {
			assetManager=new AssetManager(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			Gdx.app.exit();
			return;
		}
		if(DEBUG)
		assetManager.finishLoading();
		//TODO loading

		setScreen(new GameScreen(this));

	}

	@Override
	public void render () {

		BoxoUtil.clearScreen();
		BoxoUtil.update();
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public Logger getLogger() {
		return logger;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
}

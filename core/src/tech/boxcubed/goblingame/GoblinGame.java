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
	private static final int PPM=10;
	private AssetManager assetManager;


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
			assetManager=new AssetManager();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			Gdx.app.exit();
			return;
		}
		assetManager.finishLoading();

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
}

package tech.boxcubed.goblingame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tech.boxcubed.goblingame.screens.GameScreen;

public class GoblinGameMain extends Game {
	public SpriteBatch batch;
	Logger logger;

	public GoblinGameMain() {
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
				return "["+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND)+"] - "+record.getLevel()+": "+record.getMessage();

			}
		});

		logger.addHandler(handler);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		logger.info("Starting Goblin Game...");

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

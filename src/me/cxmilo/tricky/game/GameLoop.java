package me.cxmilo.tricky.game;

import java.util.logging.Logger;

public abstract class GameLoop {

    protected final Logger logger = Logger.getLogger(GameLoop.class.getName());

    protected volatile GameStatus status;

    protected GameController controller;
    protected Game game;

    private Thread gameThread;

    public GameLoop(Game game) {
        this.game = game;
        controller = new GameController(game, this);
        status = GameStatus.STOPPED;
    }

    public void run() {
        status = GameStatus.RUNNING;
        gameThread = new Thread(this::processGameLoop);
        gameThread.start();
    }

    public void stop() {
        status = GameStatus.STOPPED;
    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }

    protected abstract void processGameLoop();

    public Thread getGameThread() {
        return gameThread;
    }
}
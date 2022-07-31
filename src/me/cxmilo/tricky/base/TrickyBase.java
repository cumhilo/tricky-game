package me.cxmilo.tricky.base;

import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.User;
import me.cxmilo.tricky.game.Game;
import me.cxmilo.tricky.game.GameLoop;
import me.cxmilo.tricky.game.TurnBasedGameLoop;
import me.cxmilo.tricky.table.DefaultTable;
import me.cxmilo.tricky.table.Table;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TrickyBase
        implements Base {

    private static final int TABLE_SIZE = 3;

    private final Set<Point> points = new LinkedHashSet<>();
    private final Set<User> userEntities = new HashSet<>();

    private Base pointBase;
    private EntitiesBase entitiesBase;
    private GameBase gameBase;

    @Override
    public void init() {
        Table table = new DefaultTable(points, TABLE_SIZE);

        this.pointBase = new PointBase(TABLE_SIZE, points);
        this.entitiesBase = new EntitiesBase(userEntities);
        this.gameBase = new GameBase(table, userEntities);

        entitiesBase.init();
        pointBase.init();
        gameBase.init();

        Game game = gameBase.getGame();
        GameLoop loop = new TurnBasedGameLoop(game);

        loop.run();
    }

    @Override
    public void shutdown() {
        entitiesBase.shutdown();
        gameBase.shutdown();
        pointBase.shutdown();
    }
}

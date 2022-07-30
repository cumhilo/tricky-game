package me.cxmilo.tricky.base;

import me.cxmilo.tricky.entity.UserEntity;
import me.cxmilo.tricky.game.Game;
import me.cxmilo.tricky.game.impl.TrickyGame;
import me.cxmilo.tricky.table.Table;

import java.util.Set;

public class GameBase
        implements Base {

    private final Table table;
    private final Set<UserEntity> userEntities;
    private Game game;

    public GameBase(Table table, Set<UserEntity> userEntities) {
        this.table = table;
        this.userEntities = userEntities;
    }

    @Override
    public void init() {
        this.game = new TrickyGame(table, userEntities);
    }

    @Override
    public void shutdown() {
        game.setTurn(-1);
    }

    public Game getGame() {
        return game;
    }
}

package me.cxmilo.tricky.game.impl;

import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.entity.UserEntity;
import me.cxmilo.tricky.game.Game;
import me.cxmilo.tricky.table.Table;

import java.util.Set;

public class TrickyGame implements Game {

    private final Table table;
    private final Set<UserEntity> userEntities;
    private int turn;

    public TrickyGame(Table table, Set<UserEntity> userEntities) {
        this.table = table;
        this.userEntities = userEntities;
        this.turn = 0;
    }

    @Override
    public Table getTable() {
        return table;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public void setTurn(int turn) {
        this.turn = turn;
    }

    @Override
    public Set<? extends Entity> entities() {
        return userEntities;
    }
}

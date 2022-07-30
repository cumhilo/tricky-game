package me.cxmilo.tricky.game;

import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.table.Table;

import java.util.Set;

public interface Game {

    /**
     * Get the table of the game.
     *
     * @return The table of the game.
     */
    Table getTable();

    /**
     * Get the current turn of the game.
     *
     * @return The current turn of the game.
     */
    int getTurn();

    /**
     * Set the current turn of the game.
     *
     * @param turn The current turn of the game.
     */
    void setTurn(int turn);

    /**
     * Get the entities of the game.
     *
     * @return The entities of the game.
     */
    Set<? extends Entity> entities();
}

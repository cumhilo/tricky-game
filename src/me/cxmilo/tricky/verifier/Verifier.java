package me.cxmilo.tricky.verifier;

import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.game.Game;

import java.util.Set;

public interface Verifier {

    /**
     * Verify if the game is won.
     *
     * @param game   the game to verify.
     * @param entity the entity to verify for winning.
     * @param points the points to verify for winning.
     * @return true if the game is won, false otherwise.
     */
    boolean verify(Game game, Entity entity, Set<Point> points);
}

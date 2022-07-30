package me.cxmilo.tricky.verifier;

import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.game.Game;

import java.util.Set;

public class DrawVerifier implements Verifier {

    @Override
    public boolean verify(Game game, Entity entity, Set<Point> points) {
        return game.getTable().size() * game.getTable().size()  == points.size();
    }
}

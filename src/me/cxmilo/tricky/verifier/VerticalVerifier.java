package me.cxmilo.tricky.verifier;

import me.cxmilo.tricky.coordinate.Coordinates;
import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.game.Game;

import java.util.Set;

public class VerticalVerifier implements Verifier {

    @Override
    public boolean verify(Game game, Entity entity, Set<Point> points) {

        var coordinates = new Coordinates(game.getTable());
        int tableSize = game.getTable().size();
        int row = 0;

        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                var optionalPoint = coordinates.getPoint(i, j);

                if (optionalPoint.isEmpty()) {
                    continue;
                }

                var point = optionalPoint.get();

                if (!points.contains(point)) {
                    continue;
                }

                if (++row == game.getTable().size()) {
                    return true;
                }
            }
            row = 0;
        }
        return false;
    }
}

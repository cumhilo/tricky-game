package me.cxmilo.tricky.verifier;

import me.cxmilo.tricky.coordinate.Coordinates;
import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.game.Game;

import java.util.Set;

public class VerticalVerifier implements Verifier {

    @Override
    public boolean verify(Game game, Entity entity, Set<Point> points) {

        int tableSize = game.getTable().size();
        int row = 0;
        Point lastPoint = null;

        for (int i = 0; i < tableSize; i++) {
            var coordinates = new Coordinates(game.getTable());
            var optionalX = coordinates.getPoint(i, 0);

            if (optionalX.isEmpty() || optionalX.get().getOwner().isEmpty()) {
                continue;
            }

            Point xPoint = optionalX.get();
            if (!points.contains(xPoint)) {
                continue;
            }

            for (int j = 0; j < tableSize; j++) {
                var optionalY = coordinates.getPoint(i, j);

                if (optionalY.isEmpty() || optionalY.get().getOwner().isEmpty()) {
                    continue;
                }

                Point yPoint = optionalY.get();
                if (lastPoint == null) {
                    lastPoint = yPoint;
                }

                if (lastPoint.getOwner().isEmpty() || lastPoint.getOwner().get() != yPoint.getOwner().get()) {
                    continue;
                }

                if (lastPoint.getCoordinate().getX() == yPoint.getCoordinate().getX()) {
                    row++;
                }

                if (row == game.getTable().size()) {
                    return true;
                }

                lastPoint = yPoint;
            }
            lastPoint = null;
            row = 0;
        }
        return false;
    }
}

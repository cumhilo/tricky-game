package me.cxmilo.tricky.verifier;

import me.cxmilo.tricky.coordinate.Coordinate;
import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.game.Game;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HorizontalVerifier implements Verifier {

    @Override
    public boolean verify(Game game, Entity entity, Set<Point> points) {

        Set<Point> sortedPoints = points.stream().sorted(Comparator.comparingInt(value -> value.getCoordinate().getNumber())).collect(Collectors.toCollection(LinkedHashSet::new));
        Point lastPoint = null;
        int row = 0;

        for (Point point : sortedPoints) {
            if (lastPoint == null) {
                lastPoint = point;
            }

            Coordinate lastPointCoordinate = lastPoint.getCoordinate();
            Coordinate pointCoordinate = point.getCoordinate();
            if (lastPointCoordinate.getY() != pointCoordinate.getY()) {
                row = 0;
            }

            row++;

            if (row == game.getTable().size()) {
                return true;
            }

            lastPoint = point;
        }
        return false;
    }
}

package me.cxmilo.tricky.verifier;

import me.cxmilo.tricky.coordinate.Coordinate;
import me.cxmilo.tricky.coordinate.Coordinates;
import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.entity.Entity;
import me.cxmilo.tricky.game.Game;
import me.cxmilo.tricky.table.Table;

import java.util.Set;
import java.util.function.BiPredicate;

public class DiagonalVerifier implements Verifier {

    private final BiPredicate<Point, Set<Point>> pointPredicate = (point, points) -> points.contains(point);

    @Override
    public boolean verify(Game game, Entity entity, Set<Point> points) {

        int row = 0;
        var table = game.getTable();
        var coordinates = new Coordinates(table);
        for (int i = 0; i < table.size(); i++) {
            var coordinate = coordinates.getPoint(0, i);

            if (coordinate.isEmpty()) {
                continue;
            }

            var point = coordinate.get();
            var pointCoordinate = point.getCoordinate();
            if (pointCoordinate.getY() != 0 && pointCoordinate.getY() != table.size() - 1) {
                continue;
            }

            for (int j = 0; j < table.size(); j++) {
                var rightDown = coordinates.getPoint(pointCoordinate.getX() + j, pointCoordinate.getY() + j);
                var rightUp = coordinates.getPoint(pointCoordinate.getX() + j, pointCoordinate.getY() - j);
                var sum = false;

                if (rightUp.isPresent()) {
                    sum = pointPredicate.test(rightUp.get(), points);
                }

                if (!sum && rightDown.isPresent()) {
                    sum = pointPredicate.test(rightDown.get(), points);
                }

                if (sum && ++row == game.getTable().size()) {
                    return true;
                }
            }
            row = 0;
        }
        return false;
    }
}

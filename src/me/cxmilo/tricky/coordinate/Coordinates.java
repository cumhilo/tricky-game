package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.table.Table;

import java.util.Optional;

public class Coordinates {

    private static final int[][] EMPTY_COORDINATES = new int[0][0];
    private final Table table;

    public Coordinates(Table table) {
        this.table = table;
    }

    public int[][] toLocation(int number) {
        Optional<Point> optionalPoint = getPoint(number);
        if (optionalPoint.isEmpty()) {
            return EMPTY_COORDINATES;
        }

        Point point = optionalPoint.get();
        return new int[][]{
                {point.getCoordinate().getX(), point.getCoordinate().getY()},
        };
    }

    public int fromLocation(int x, int y) {
        return x + (y * table.size());
    }

    public Optional<Point> getPoint(int number) {
        return table.points().stream().filter(point -> point.getCoordinate().getNumber() == number).findFirst();
    }
}

package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.table.Table;

import java.util.Optional;

public class Coordinates {

    private static final int[][] EMPTY_COORDINATES = new int[0][0];
    private final Table table;

    public Coordinates(Table table) {
        this.table = table;
    }

    /**
     * Convert the coordinate to the index of the point in the table.
     *
     * @param number the number of the coordinate.
     * @return the index of the point in the table.
     */
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

    /**
     * Convert a location to a number.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The number.
     */
    public int fromLocation(int x, int y) {
        return x + (y * table.size());
    }

    /**
     * Get the point at the given coordinate.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The point.
     */
    public Optional<Point> getPoint(int x, int y) {
        return getPoint(fromLocation(x, y));
    }

    /**
     * Get the point of the given number.
     *
     * @param number The number of the point.
     * @return The point of the given number.
     */
    public Optional<Point> getPoint(int number) {
        Optional<Point> optionalPoint = Optional.empty();

        for (Point point : table.points()) {
            if (point.getCoordinate().getNumber() == number) {
                optionalPoint = Optional.of(point);
                break;
            }
        }

        return optionalPoint;
    }
}

package me.cxmilo.tricky.base;

import me.cxmilo.tricky.coordinate.DefaultCoordinate;
import me.cxmilo.tricky.coordinate.Point;
import me.cxmilo.tricky.coordinate.PointsBuilder;

import java.util.Set;

public class PointBase
        implements Base {

    private final int tableSize;
    private final Set<Point> points;

    public PointBase(int tableSize, Set<Point> points) {
        this.tableSize = tableSize;
        this.points = points;
    }

    @Override
    public void init() {
        for (int i = 0; i < tableSize * tableSize; i++) {
            points.add(new PointsBuilder()
                    .setCoordinate(new DefaultCoordinate(i, tableSize))
                    .setOwner(null)
                    .createPoints());
        }
    }

    @Override
    public void shutdown() {
        points.clear();
    }
}

package me.cxmilo.tricky.table;

import me.cxmilo.tricky.coordinate.Point;

import java.util.Set;

public record DefaultTable(Set<Point> points, int size)
        implements Table {

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<Point> points() {
        return points;
    }
}

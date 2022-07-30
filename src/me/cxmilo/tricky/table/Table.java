package me.cxmilo.tricky.table;

import me.cxmilo.tricky.coordinate.Point;

import java.util.Set;

/*
 * Numerical coordinates are used to represent the position of a table:
 *
 * [0|1|2]
 * [3|4|5]
 * [6|7|8]
 *
 * 2d coordinates are:
 * X       Y
 * [0|1|2] [0|0|0]
 * [0|1|2] [1|1|1]
 * [0|1|2] [2|2|2]
 */
public interface Table {

    /**
     * Get the points of the table.
     *
     * @return the points of the table.
     */
    Set<Point> points();

    /**
     * Get the size of the table.
     *
     * @return the size of the table.
     */
    int size();
}

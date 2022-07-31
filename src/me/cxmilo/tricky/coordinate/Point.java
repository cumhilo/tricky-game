package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.entity.User;

import java.util.Optional;

public interface Point extends Comparable<Point> {

    /**
     * Get the Owner of the point.
     *
     * @return The owner of the point.
     */
    Optional<User> getOwner();

    /**
     * Set the owner of the point.
     *
     * @param User The owner of the point.
     */
    void setOwner(User User);

    /**
     * Get the coordinate of the point.
     *
     * @return The coordinate of the point.
     */
    Coordinate getCoordinate();
}

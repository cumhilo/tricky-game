package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.entity.UserEntity;

import java.util.Optional;

public interface Point extends Comparable<Point> {

    /**
     * Get the Owner of the point.
     *
     * @return The owner of the point.
     */
    Optional<UserEntity> getOwner();

    /**
     * Set the owner of the point.
     *
     * @param UserEntity The owner of the point.
     */
    void setOwner(UserEntity UserEntity);

    /**
     * Get the coordinate of the point.
     *
     * @return The coordinate of the point.
     */
    Coordinate getCoordinate();
}

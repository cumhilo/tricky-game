package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.entity.UserEntity;

public class PointsBuilder {
    private UserEntity owner;
    private Coordinate coordinate;

    public PointsBuilder setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public PointsBuilder setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public Points createPoints() {
        return new Points(owner, coordinate);
    }
}
package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.entity.User;

public class PointsBuilder {

    private User owner;
    private Coordinate coordinate;

    public PointsBuilder setOwner(User owner) {
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
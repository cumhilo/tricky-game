package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.entity.UserEntity;

import java.util.Comparator;
import java.util.Optional;

public class Points implements Point {

    private UserEntity owner;
    private Coordinate coordinate;

    public Points(UserEntity owner, Coordinate coordinate) {
        this.owner = owner;
        this.coordinate = coordinate;
    }

    @Override
    public Optional<UserEntity> getOwner() {
        return Optional.ofNullable(owner);
    }

    @Override
    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public int compareTo(Point o) {
        return Comparator.comparingInt(point -> this.getCoordinate().getNumber()).compare(this.coordinate.getNumber(), o.getCoordinate().getNumber());
    }
}

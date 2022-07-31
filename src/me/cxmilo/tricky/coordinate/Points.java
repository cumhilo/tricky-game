package me.cxmilo.tricky.coordinate;

import me.cxmilo.tricky.entity.User;

import java.util.Comparator;
import java.util.Optional;

public class Points implements Point {

    private User owner;
    private Coordinate coordinate;

    public Points(User owner, Coordinate coordinate) {
        this.owner = owner;
        this.coordinate = coordinate;
    }

    @Override
    public Optional<User> getOwner() {
        return Optional.ofNullable(owner);
    }

    @Override
    public void setOwner(User owner) {
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

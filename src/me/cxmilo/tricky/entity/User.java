package me.cxmilo.tricky.entity;

import me.cxmilo.tricky.component.Component;
import me.cxmilo.tricky.coordinate.Point;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User
        implements Entity {

    private final String name;
    private final short id;
    private final char decorator;
    private final Set<Point> scoredPoints;

    public User(String name, short id, char decorator) {
        this.name = name;
        this.id = id;
        this.decorator = decorator;
        this.scoredPoints = new HashSet<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public short getId() {
        return id;
    }

    public char getDecorator() {
        return decorator;
    }

    @Override
    public Set<Component> getComponents() {
        return Collections.emptySet();
    }

    public Set<Point> getScoredPoints() {
        return scoredPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id == user.id && decorator == user.decorator && name.equals(user.name) && scoredPoints.equals(user.scoredPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, decorator, scoredPoints);
    }
}

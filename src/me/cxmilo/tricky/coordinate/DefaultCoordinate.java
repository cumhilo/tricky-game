package me.cxmilo.tricky.coordinate;

public record DefaultCoordinate(int number, int tableSize)
        implements Coordinate {

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getX() {
        return number - (getY() * tableSize);
    }

    @Override
    public int getY() {
        return Math.floorDiv(number, tableSize);
    }
}

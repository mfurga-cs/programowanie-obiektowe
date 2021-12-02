package lab7;

import lab2.MoveDirection;
import lab7.map.IPositionChangeObserver;
import lab7.map.IWorldMap;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {

    private static final Vector2d INIT_POSITION = new Vector2d(2, 2);
    private static final MapDirection INIT_DIRECTION = MapDirection.NORTH;

    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();
    private MapDirection direction;
    private Vector2d position;

    public Animal(IWorldMap map) {
        this(map, INIT_POSITION);
    }

    public Animal(IWorldMap map, Vector2d initPosition) {
        this(map, initPosition, INIT_DIRECTION);
    }

    public Animal(IWorldMap map, Vector2d initPosition, MapDirection initDirection) {
        this.map = map;
        this.direction = initDirection;
        this.position = initPosition;
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> this.position = move(this.direction.toUnitVector());
            case BACKWARD -> this.position = move(this.direction.toUnitVector().opposite());
        }
    }

    private Vector2d move(Vector2d vector) {
        Vector2d newPosition = this.position.add(vector);
        newPosition = new Vector2d(Math.floorMod(newPosition.x, map.getWidth()),
                                   Math.floorMod(newPosition.y, map.getHeight()));

        if (this.map.canMoveTo(newPosition)) {
            this.positionChanged(this.position, newPosition);
            return newPosition;
        }

        return this.position;
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return switch (this.direction) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }
}

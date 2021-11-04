package lab4;

import lab2.MapDirection;
import lab2.MoveDirection;
import lab2.Vector2d;

public class Animal {

    private static final Vector2d INIT_POSITION = new Vector2d(2, 2);
    private static final MapDirection INIT_DIRECTION = MapDirection.NORTH;

    private final IWorldMap map;
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
        newPosition = new Vector2d(Math.floorMod(newPosition.x, ((RectangularMap)map).getWidth()),
                                   Math.floorMod(newPosition.y, ((RectangularMap)map).getHeight()));
        return this.map.canMoveTo(newPosition) ? newPosition : this.position;
    }

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

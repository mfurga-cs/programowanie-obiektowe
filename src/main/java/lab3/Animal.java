package lab3;

import lab2.MapDirection;
import lab2.MoveDirection;
import lab2.Vector2d;

public class Animal {
    public static int MAX = 5;

    private MapDirection direction;
    private Vector2d position;

    public Animal() {
        direction = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> this.position = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> this.position = this.position.add(this.direction.toUnitVector().opposite());
        }
        this.position = new Vector2d(Math.floorMod(this.position.x, MAX), Math.floorMod(this.position.y, MAX));
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "direction=" + this.direction + ", position=" + this.position;
    }
}

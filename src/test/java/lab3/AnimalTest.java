package lab3;

import lab2.MapDirection;
import lab2.MoveDirection;
import lab2.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {

    @Test
    public void initTest() {
        Animal animal = new Animal();
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));
    }

    @Test
    public void moveDirectionLeftRightTest() {
        Animal animal = new Animal();

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));
    }

    @Test
    public void moveDirectionForwardBackwardTest() {
        Animal animal = new Animal();

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 3)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 4)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 0)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 1)));

        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 0)));

        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 4)));
    }

    @Test
    public void moveDirectionMultiTest() {
        Animal animal = new Animal();

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertTrue(animal.getPosition().equals(new Vector2d(1, 2)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertTrue(animal.getPosition().equals(new Vector2d(0, 2)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 2)));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 2)));

        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 3)));

        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 4)));

        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 0)));
    }
}

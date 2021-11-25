package lab6.map.impl;

import lab6.Vector2d;
import lab6.Animal;
import lab6.map.IWorldMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    IWorldMap map;
    Animal animal1, animal2;

    @BeforeEach
    void init() {
        this.map = new RectangularMap(10, 10);
        this.animal1 = new Animal(map, new Vector2d(3, 9));
        this.animal2 = new Animal(map, new Vector2d(1, 3));
    }

    @Test
    void canMoveTo() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assertTrue(map.canMoveTo(new Vector2d(2, 1)));
        assertFalse(map.canMoveTo(new Vector2d(1, 3)));
        assertFalse(map.canMoveTo(new Vector2d(3, 9)));
    }

    @Test
    void place() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assertTrue(map.place(new Animal(map, new Vector2d(4, 4))));
        assertTrue(map.place(new Animal(map, new Vector2d(7, 1))));
        assertFalse(map.place(new Animal(map, new Vector2d(1, 3))));
        assertFalse(map.place(new Animal(map, new Vector2d(3, 9))));
    }

    @Test
    void isOccupied() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assertFalse(map.isOccupied(new Vector2d(3, 2)));
        assertFalse(map.isOccupied(new Vector2d(9, 9)));
    }

    @Test
    void objectAt() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assertNotNull(map.objectAt(new Vector2d(3, 9)));
        assertNotNull(map.objectAt(new Vector2d(1, 3)));
        assertNull(map.objectAt(new Vector2d(9, 2)));
        assertNull(map.objectAt(new Vector2d(4, 3)));
    }
}

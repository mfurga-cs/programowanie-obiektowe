package lab5.map.impl;

import lab2.Vector2d;
import lab5.Animal;
import lab5.Grass;
import lab5.map.IWorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class GrassFieldMapTest {
    IWorldMap map;
    Animal animal1, animal2;

    @BeforeEach
    void init() {
        this.map = new GrassFieldMap(10);
        this.animal1 = new Animal(map, new Vector2d(3, 9));
        this.animal2 = new Animal(map, new Vector2d(1, 3));
    }

    @RepeatedTest(100)
    void canMoveTo() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assumeTrue(((GrassFieldMap) map).findElementsByType(Animal.class).size() == 2, "Could not place animals.");

        assertFalse(this.map.canMoveTo(new Vector2d(1, 3)));
        assertFalse(this.map.canMoveTo(new Vector2d(3, 9)));
    }

    @RepeatedTest(100)
    void place() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assumeTrue(((GrassFieldMap) map).findElementsByType(Animal.class).size() == 2, "Could not place animals.");

        assertFalse(this.map.place(new Animal(map, new Vector2d(1, 3))));
        assertFalse(this.map.place(new Animal(map, new Vector2d(3, 9))));
    }

    @RepeatedTest(100)
    void isOccupied() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assumeTrue(((GrassFieldMap) map).findElementsByType(Animal.class).size() == 2, "Could not place animals.");

        assertTrue(map.objectAt(new Vector2d(3, 9)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(1, 3)) instanceof Animal);

        assertTrue(map.isOccupied(new Vector2d(3, 9)));
        assumeTrue(map.isOccupied(new Vector2d(1, 3)));
    }

    @RepeatedTest(100)
    void objectAt() {
        this.map.place(this.animal1);
        this.map.place(this.animal2);

        assumeTrue(((GrassFieldMap) map).findElementsByType(Animal.class).size() == 2, "Could not place animals.");

        assertNotNull(map.objectAt(new Vector2d(3, 9)));
        assertNotNull(map.objectAt(new Vector2d(1, 3)));
    }
}

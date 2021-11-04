package lab4;

import lab2.MapDirection;
import lab2.MoveDirection;
import lab2.Vector2d;
import lab3.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    @Test
    public void runTest() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f"});
        IWorldMap map = new RectangularMap(10, 5);

        Animal[] animals = new Animal[2];

        animals[0] = new Animal(map, new Vector2d(2, 2));
        animals[1] = new Animal(map, new Vector2d(3, 4));

        map.place(animals[0]);
        map.place(animals[1]);

        assertTrue(animals[0].getPosition().equals(new Vector2d(2, 2)));
        assertEquals(animals[0].getDirection(), MapDirection.NORTH);

        assertTrue(animals[1].getPosition().equals(new Vector2d(3, 4)));
        assertEquals(animals[1].getDirection(), MapDirection.NORTH);

        int i = 0;

        animals[i % animals.length].move(directions[i]);
        assertTrue(animals[i % animals.length].getPosition().equals(new Vector2d(2, 3)));
        assertEquals(animals[i % animals.length].getDirection(), MapDirection.NORTH);

        i++;

        animals[i % animals.length].move(directions[i]);
        assertTrue(animals[i % animals.length].getPosition().equals(new Vector2d(3, 3)));
        assertEquals(animals[i % animals.length].getDirection(), MapDirection.NORTH);

        i++;

        animals[i % animals.length].move(directions[i]);
        assertTrue(animals[i % animals.length].getPosition().equals(new Vector2d(2, 3)));
        assertEquals(animals[i % animals.length].getDirection(), MapDirection.EAST);

        i++;

        animals[i % animals.length].move(directions[i]);
        assertTrue(animals[i % animals.length].getPosition().equals(new Vector2d(3, 3)));
        assertEquals(animals[i % animals.length].getDirection(), MapDirection.WEST);

        i++;

        animals[i % animals.length].move(directions[i]);
        System.out.println(animals[i % animals.length].getPosition());
        assertTrue(animals[i % animals.length].getPosition().equals(new Vector2d(2, 3)));
        assertEquals(animals[i % animals.length].getDirection(), MapDirection.EAST);

        i++;

        animals[i % animals.length].move(directions[i]);
        assertTrue(animals[i % animals.length].getPosition().equals(new Vector2d(3, 3)));
        assertEquals(animals[i % animals.length].getDirection(), MapDirection.WEST);
    }
}

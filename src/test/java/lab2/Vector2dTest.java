package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    public void equalsTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(1, 2);

        assertTrue(a.equals(b));
    }

    @Test
    public void toStringTest() {
        Vector2d vector = new Vector2d(1, 2);
        assertEquals("(1, 2)", vector.toString());

        vector = new Vector2d(-1, 0);
        assertEquals("(-1, 0)", vector.toString());
    }

    @Test
    public void precedesTest() {
        Vector2d a = new Vector2d(1, 0);
        Vector2d b = new Vector2d(1, 1);

        assertTrue(a.precedes(b));
        assertFalse(b.precedes(a));
    }

    @Test
    public void followsTest() {
        Vector2d a = new Vector2d(-1, 0);
        Vector2d b = new Vector2d(-1, -1);

        assertTrue(a.follows(b));
        assertFalse(b.follows(a));
    }

    @Test
    public void upperRightTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(3, 4);

        Vector2d result = a.upperRight(b);

        assertEquals(result.x, 3);
        assertEquals(result.y, 4);

        a = new Vector2d(3, 1);
        b = new Vector2d(-1, 4);

        result = a.upperRight(b);

        assertEquals(result.x, 3);
        assertEquals(result.y, 4);
    }

    @Test
    public void lowerLeftTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(3, 4);

        Vector2d result = a.lowerLeft(b);

        assertEquals(result.x, 1);
        assertEquals(result.y, 2);

        a = new Vector2d(3, 1);
        b = new Vector2d(-1, 4);

        result = a.lowerLeft(b);

        assertEquals(result.x, -1);
        assertEquals(result.y, 1);
    }

    @Test
    public void addtTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(-1, 4);

        Vector2d result = a.add(b);

        assertEquals(result.x, 0);
        assertEquals(result.y, 6);

        a = new Vector2d(3, 1);
        b = new Vector2d(-1, -4);

        result = a.add(b);

        assertEquals(result.x, 2);
        assertEquals(result.y, -3);
    }

    @Test
    public void subtractTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(-1, -4);

        Vector2d result = a.subtract(b);

        assertEquals(result.x, 2);
        assertEquals(result.y, 6);

        a = new Vector2d(-1, -3);
        b = new Vector2d(3, 5);

        result = a.subtract(b);

        assertEquals(result.x, -4);
        assertEquals(result.y, -8);
    }

    @Test
    public void oppositeTest() {
        Vector2d a = new Vector2d(1, 2);

        Vector2d ao = a.opposite();

        assertEquals(ao.x, -1);
        assertEquals(ao.y, -2);

        Vector2d b = new Vector2d(-3, 5);

        Vector2d bo = b.opposite();

        assertEquals(bo.x, 3);
        assertEquals(bo.y, -5);
    }
}
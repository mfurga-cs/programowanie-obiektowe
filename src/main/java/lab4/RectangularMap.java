package lab4;

import lab2.Vector2d;
import lab4.Animal;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private final List<Animal> animals = new ArrayList<Animal>();
    private final int width;
    private final int height;

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;

        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition())) {
            return false;
        }
        return animals.add(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals
                .stream()
                .anyMatch(animal -> animal.getPosition().equals(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals
                .stream()
                .filter(animal -> animal.getPosition().equals(position))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}

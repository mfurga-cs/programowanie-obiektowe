package lab5.map.impl;

import lab2.Vector2d;
import lab5.Animal;
import lab5.IMapElement;
import lab5.map.IWorldMap;
import lab5.map.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap {

    protected final List<IMapElement> elements = new ArrayList<IMapElement>();
    protected int width;
    protected int height;

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    protected <T extends IMapElement> List<T> findElementsByType(Class<T> klass) {
        return this.elements
                .stream()
                .filter(e -> e.getClass().equals(klass))
                .map(e -> (T) e)
                .collect(Collectors.toList());
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
        return this.elements.add(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        return this.elements
                .stream()
                .filter(animal -> animal.getPosition().equals(position))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean remove(IMapElement element) {
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i) == element) {
                this.elements.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}

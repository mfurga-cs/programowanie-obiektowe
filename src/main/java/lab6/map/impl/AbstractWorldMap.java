package lab6.map.impl;

import lab6.Vector2d;
import lab6.Animal;
import lab6.IMapElement;
import lab6.map.IPositionChangeObserver;
import lab6.map.IWorldMap;
import lab6.map.MapVisualizer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected final Map<Vector2d, IMapElement> elements = new LinkedHashMap<>();
    protected int width;
    protected int height;

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    protected <T extends IMapElement> List<T> findElementsByType(Class<T> klass) {
        return this.elements
                .values()
                .stream()
                .filter(e -> e.getClass().equals(klass))
                .map(e -> (T) e)
                .collect(Collectors.toList());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = this.elements.get(oldPosition);
        this.elements.remove(oldPosition);
        this.elements.put(newPosition, element);
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
        this.elements.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        if (!this.elements.containsKey(position)) {
            return null;
        }
        return this.elements.get(position);
    }

    @Override
    public boolean remove(IMapElement element) {
        return this.elements.remove(element.getPosition()) != null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}

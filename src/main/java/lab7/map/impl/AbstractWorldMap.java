package lab7.map.impl;

import lab7.Animal;
import lab7.IMapElement;
import lab7.Vector2d;
import lab7.map.IPositionChangeObserver;
import lab7.map.IWorldMap;
import lab7.map.MapVisualizer;
import lab7.utils.Pair;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected final Map<Vector2d, IMapElement> elements = new LinkedHashMap<>();
    protected final MapBoundary mapBoundary = new MapBoundary();

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
        this.mapBoundary.positionChanged(oldPosition, newPosition);
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
        this.mapBoundary.addElement(animal.getPosition(), animal);
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
        this.mapBoundary.removeElement(element.getPosition());
        return this.elements.remove(element.getPosition()) != null;
    }

    @Override
    public String toString() {
        Pair<Vector2d, Vector2d> boundary = this.mapBoundary.getBoundaries();
        // return new MapVisualizer(this).draw(boundary.getFirst(), boundary.getSecond());
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

package lab7.map.impl;

import lab7.IMapElement;
import lab7.map.IPositionChangeObserver;
import lab7.Vector2d;
import lab7.utils.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapBoundary implements IPositionChangeObserver {

    private Map<Vector2d, IMapElement> elements = new HashMap<>();
    private TreeMap<Vector2d, IMapElement> xAxisElements = new TreeMap<>(MapBoundary.Compare::compareByXAxis);
    private TreeMap<Vector2d, IMapElement> yAxisElements = new TreeMap<>(MapBoundary.Compare::compareByYAxis);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = this.elements.get(oldPosition);
        this.removeElement(oldPosition);
        this.addElement(newPosition, element);
    }

    public void removeElement(Vector2d position) {
        this.elements.remove(position);
        this.xAxisElements.remove(position);
        this.yAxisElements.remove(position);
    }

    public void addElement(Vector2d position, IMapElement element) {
        this.elements.put(position, element);
        this.xAxisElements.put(position, element);
        this.yAxisElements.put(position, element);
    }

    public Pair<Vector2d, Vector2d> getBoundaries() {
        int minX = this.xAxisElements.firstKey().x;
        int maxX = this.xAxisElements.lastKey().x;

        int minY = this.yAxisElements.firstKey().y;
        int maxY = this.yAxisElements.lastKey().y;

        return new Pair<>(new Vector2d(minX, minY), new Vector2d(maxX, maxY));
    }

    private static class Compare {

        private static int compareByXAxis(Vector2d vector1, Vector2d vector2) {
            if (vector1.x > vector2.x) return 1;
            if (vector1.x < vector2.x) return -1;
            if (vector1.y > vector2.y) return 1;
            if (vector1.y < vector2.y) return -1;
            return 0;
        }

        private static int compareByYAxis(Vector2d vector1, Vector2d vector2) {
            if (vector1.y > vector2.y) return 1;
            if (vector1.y < vector2.y) return -1;

            if (vector1.x > vector2.x) return 1;
            if (vector1.x < vector2.x) return -1;

            return 0;
        }
    }
}

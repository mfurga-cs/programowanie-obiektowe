package lab5.map.impl;

import lab2.Vector2d;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;

        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }
}

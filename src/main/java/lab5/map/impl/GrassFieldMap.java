package lab5.map.impl;

import java.util.concurrent.ThreadLocalRandom;

import lab2.Vector2d;
import lab5.Grass;
import lab5.IMapElement;

public class GrassFieldMap extends AbstractWorldMap {

    private final int targetGrassFields;

    public GrassFieldMap(int grassFields) {
        this.targetGrassFields = grassFields;
        this.width = (int)Math.sqrt(grassFields * 10);
        this.height = (int)Math.sqrt(grassFields * 10);

        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(this.width - 1, this.height - 1);

        generateRandomGrassFields();
    }

    @Override
    public boolean remove(IMapElement element) {
        boolean result = super.remove(element);
        generateRandomGrassFields();
        return result;
    }

    private void generateRandomGrassFields() {
        int currentGrassFields = this.findElementsByType(Grass.class).size();
        for (int i = currentGrassFields; i < this.targetGrassFields; i++) {
            Vector2d v;
            do {
                v = new Vector2d(ThreadLocalRandom.current().nextInt(0, this.width),
                                 ThreadLocalRandom.current().nextInt(0, this.height));
            } while (this.isOccupied(v));
            this.elements.add(new Grass(v));
        }
    }
}

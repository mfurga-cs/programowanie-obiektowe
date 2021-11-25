package lab6;

import lab2.MoveDirection;
import lab6.Vector2d;
import lab4.IEngine;
import lab6.map.IWorldMap;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private List<Animal> animals = new ArrayList<Animal>();

    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            this.animals.add(animal);
            this.map.place(animal);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < this.directions.length; i++) {
            this.animals.get(i % this.animals.size()).move(directions[i]);
        }
    }
}

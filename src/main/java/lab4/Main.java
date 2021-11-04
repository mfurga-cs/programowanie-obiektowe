package lab4;

import lab2.MoveDirection;
import lab2.Vector2d;
import lab3.OptionsParser;

public class Main {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);

        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        System.out.println(map);
        engine.run();
        System.out.println(map);
    }

}

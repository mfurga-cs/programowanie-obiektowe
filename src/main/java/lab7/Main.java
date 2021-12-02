package lab7;

import lab2.MoveDirection;
import lab4.IEngine;
import lab7.map.IWorldMap;
import lab7.map.impl.GrassFieldMap;

public class Main {

    public static void main(String[] args) {

        try {
            String[] asdf = {"f", "b" ,"r" ,"l" ,"f" ,"f", "r", "r", "f", "f" ,"f" ,"f" ,"f" ,"f" ,"f", "f"};
            MoveDirection[] directions = OptionsParser.parse(asdf);

            IWorldMap map = new GrassFieldMap(10);

            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);

            System.out.println(map);
            engine.run();
            System.out.println(map);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}

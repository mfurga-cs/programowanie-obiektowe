package lab5;

import lab2.MoveDirection;
import lab2.Vector2d;
import lab3.OptionsParser;
import lab4.IEngine;
import lab5.map.IWorldMap;
import lab5.map.impl.GrassFieldMap;

public class Main {

    public static void main(String[] args) {
        String[] asdf = {"f" ,"b" ,"r" ,"l" ,"f" ,"f", "r", "r", "f", "f" ,"f" ,"f" ,"f" ,"f" ,"f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(asdf);

        IWorldMap map = new GrassFieldMap(10);

        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        System.out.println(map);
        engine.run();
        System.out.println(map);

    }

}

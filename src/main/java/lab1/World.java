package lab1;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {
        List<Direction> moves = new ArrayList<Direction>();

        System.out.println("Start");

        for (String arg: args) {
            switch (arg) {
                case "f" -> moves.add(Direction.FORWARD);
                case "b" -> moves.add(Direction.BACKWARD);
                case "r" -> moves.add(Direction.RIGHT);
                case "l" -> moves.add(Direction.LEFT);
            }
        }

        run(moves);
        System.out.println("Stop");
    }

    public static void run(List<Direction> moves) {
        for (Direction move: moves) {
            switch (move) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
            }
        }
    }
}

package lab7;

import lab2.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static MoveDirection[] parse(String[] moves) {
        List<MoveDirection> directions = new ArrayList<MoveDirection>();
        for (String move : moves) {
            switch (move) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException("`" + move + "` is not legal move specification");
            }
        }
        return directions.toArray(MoveDirection[]::new);
    }

}

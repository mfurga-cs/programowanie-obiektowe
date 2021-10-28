package lab3;

import lab2.MoveDirection;

public class Main {

    public static void main(String[] args) {
        String[] dirs = {"f", "b", "f", "f", "forward", "r", "b", "r", "f"};
        Animal animal = new Animal();

        MoveDirection[] directions = OptionsParser.parse(dirs);
        for (MoveDirection direction : directions) {
            animal.move(direction);
            System.out.println(animal);
        }
    }
}

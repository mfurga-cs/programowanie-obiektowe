package lab2;

public class Main {

    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.EAST;
        System.out.println(direction);
        System.out.println(direction.toUnitVector());
        System.out.println(direction.next());
        System.out.println(direction.previous());
    }

}

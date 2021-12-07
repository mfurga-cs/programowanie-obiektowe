package lab7;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import lab2.MoveDirection;
import lab4.IEngine;
import lab7.map.IWorldMap;
import lab7.map.impl.GrassFieldMap;

public class App extends Application {

    private final static int CONSTRAINTS_SIZE = 20;

    private IWorldMap map;
    private IEngine engine;

    @Override
    public void init() throws Exception {
        super.init();

//        String[] moves = {"f", "b" ,"r" ,"l" ,"f" ,"f", "r", "r", "f", "f" ,"f" ,"f" ,"f" ,"f" ,"f", "f"};
        String[] moves = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = OptionsParser.parse(moves);

        this.map = new GrassFieldMap(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        this.engine = new SimulationEngine(directions, map, positions);
        this.engine.run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        Label label1 = new Label("y/x");
        grid.add(label1, 0, 0, 1, 1);
        grid.getColumnConstraints().add(new ColumnConstraints(CONSTRAINTS_SIZE));
        grid.getRowConstraints().add(new RowConstraints(CONSTRAINTS_SIZE));

        int width = this.map.getWidth();
        int height = this.map.getHeight();

        for (int i = 0; i < width; i++) {
            Label label = new Label(Integer.toString(i));
            grid.add(label, 1 + i, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(CONSTRAINTS_SIZE));
            grid.getRowConstraints().add(new RowConstraints(CONSTRAINTS_SIZE));
            grid.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < height; i++) {
            Label label = new Label(Integer.toString(i));
            grid.add(label, 0, (height - i), 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(CONSTRAINTS_SIZE));
            grid.getRowConstraints().add(new RowConstraints(CONSTRAINTS_SIZE));
            grid.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Vector2d v = new Vector2d(i, j);
                if (this.map.isOccupied(v)) {
                    Label label = new Label(this.map.objectAt(v).toString());
                    grid.add(label, 1 + i, height - j, 1, 1);
                    grid.getColumnConstraints().add(new ColumnConstraints(CONSTRAINTS_SIZE));
                    grid.getRowConstraints().add(new RowConstraints(CONSTRAINTS_SIZE));
                    grid.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(grid, CONSTRAINTS_SIZE * (width + 1), CONSTRAINTS_SIZE * (height + 1));

        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println(this.map);
    }
}

package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application implements IPositionChangeObserver {
    AbstractWorldMap map;
    GridPane grid = new GridPane();
    MapBoundary bound;
    Label label;
    int width = 40;
    int height = 40;
    VBox box;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.grid.setGridLinesVisible(true);
        this.grid.setAlignment(Pos.BASELINE_CENTER);
        int moveDelay = 300;
        Button btn = new Button();
        btn.setText("Start");
        final TextField textField = new TextField();
        HBox hBox = new HBox(10);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        VBox vBox = new VBox(20);
        vBox.getChildren().add(grid);
        vBox.getChildren().add(hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        try {
            this.map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
            SimulationEngine engine = new SimulationEngine(this.map, positions,this);
            engine.setDelay(moveDelay);
            Thread firstThread = new Thread(engine);
            firstThread.start();
            btn.setOnAction((e)->{
                Thread engineThread = new Thread(engine);
                String textFieldText = textField.getText();
                String[] args = textFieldText.split(" ");
                MoveDirection[] directions = new OptionParser().parse(args);
                engine.setMoves(directions);
                engineThread.start();
            });
        } catch(IllegalArgumentException ex) {
            System.out.println("Error: " +ex.getMessage());
            throw new Exception("Error: " +ex.getMessage());
        }
    }
    public void render(){
        Platform.runLater(() -> {
            int x = 0;
            int y;
            int j = 1;
            this.bound = this.map.getBound();
            int min_x = bound.X_el.get(0).getPosition().x;
            int max_x = bound.X_el.get(bound.X_el.size()-1).getPosition().x;
            int min_y = bound.Y_el.get(0).getPosition().y;
            int max_y = bound.Y_el.get(bound.Y_el.size()-1).getPosition().y;
            Node gr = grid.getChildren().get(0);
            grid.getRowConstraints().clear();
            grid.getColumnConstraints().clear();
            grid.getChildren().clear();
            grid.add(gr,0,0);
            grid.setGridLinesVisible(true);
            label = new Label("y/x");
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            grid.getRowConstraints().add(new RowConstraints(height));
            grid.add(label,0,0,1,1);
            for (int i = min_x; i <= max_x; i++){
                grid.getColumnConstraints().add(new ColumnConstraints(width));
                label = new Label(Integer.toString(i));
                GridPane.setHalignment(label, HPos.CENTER);
                grid.add(label,j,0,1,1);
                j+=1;
            }
            j = 1;
            for (int i = max_y; i >= min_y; i--){
                grid.getRowConstraints().add(new RowConstraints(height));
                label = new Label(Integer.toString(i));
                GridPane.setHalignment(label, HPos.CENTER);
                grid.add(label,0,j,1,1);
                j+=1;
            }

            for(int a = min_x; a <= max_x; a++){
                x += 1;
                y = 0;
                for (int b = max_y; b >= min_y; b--){
                    y += 1;
                    Object obiekt = map.objectAt(new Vector2d(a,b));
                    if(obiekt != null){
                        AbstractWorldMapElement el = (AbstractWorldMapElement) obiekt;
                        box = new GuiElementBox(el).show();
                        grid.add(box,x,y,1,1);
                    }
                }
            }
        });
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.render();
    }
}

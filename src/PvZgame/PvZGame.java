package PvZgame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PvZGame extends Application {

    class Zombie extends Rectangle {
        double speed = 1;

        Zombie(double x, double y) {
            super(40, 60, Color.GREEN);
            setX(x);
            setY(y);
        }

        void move() {
            setX(getX() - speed);
        }
    }

    class Plant extends Rectangle {
        Plant(double x, double y) {
            super(40, 60, Color.BLUE);
            setX(x);
            setY(y);
        }
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        Plant plant = new Plant(100, 200);
        Zombie zombie = new Zombie(700, 200);

        root.getChildren().addAll(plant, zombie);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                zombie.move();
                if (zombie.getX() < plant.getX() + plant.getWidth()) {
                    stop();
                    System.out.println("Zombie ate the plant! Game Over!");
                }
            }
        };
        timer.start();

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

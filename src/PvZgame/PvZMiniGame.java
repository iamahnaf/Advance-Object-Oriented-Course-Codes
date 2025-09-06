package PvZgame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PvZMiniGame extends Application {

    Pane root;
    ArrayList<Plant> plants = new ArrayList<>();
    ArrayList<Zombie> zombies = new ArrayList<>();
    ArrayList<Pea> peas = new ArrayList<>();

    Random random = new Random();
    long lastZombieSpawn = 0;

    class Plant extends Rectangle {
        long lastShot = 0;

        Plant(double x, double y) {
            super(40, 60, Color.BLUE);
            setX(x);
            setY(y);
        }

        void shoot(long now) {
            if (now - lastShot > 1_000_000_000) { // shoot every 1 second
                Pea pea = new Pea(getX() + getWidth(), getY() + 20);
                peas.add(pea);
                root.getChildren().add(pea);
                lastShot = now;
            }
        }
    }

    class Zombie extends Rectangle {
        double speed = 0.5;
        int health = 3;

        Zombie(double x, double y) {
            super(40, 60, Color.GREEN);
            setX(x);
            setY(y);
        }

        void move() {
            setX(getX() - speed);
        }
    }

    class Pea extends Circle {
        double speed = 3;

        Pea(double x, double y) {
            super(x, y, 8, Color.LIGHTGREEN);
        }

        void move() {
            setCenterX(getCenterX() + speed);
        }
    }

    @Override
    public void start(Stage stage) {
        root = new Pane();
        root.setStyle("-fx-background-color: lightgreen;");
        Scene scene = new Scene(root, 800, 600);

        // Click to place a plant
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Plant plant = new Plant(e.getX(), e.getY());
            plants.add(plant);
            root.getChildren().add(plant);
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Spawn zombies every 3 sec
                if (now - lastZombieSpawn > 3_000_000_000L) {
                    Zombie zombie = new Zombie(800, random.nextInt(5) * 100 + 50);
                    zombies.add(zombie);
                    root.getChildren().add(zombie);
                    lastZombieSpawn = now;
                }

                // Plants shooting
                for (Plant plant : plants) {
                    plant.shoot(now);
                }

                // Move peas
                Iterator<Pea> peaIterator = peas.iterator();
                while (peaIterator.hasNext()) {
                    Pea pea = peaIterator.next();
                    pea.move();

                    // Check collision with zombies
                    Iterator<Zombie> zombieIterator = zombies.iterator();
                    while (zombieIterator.hasNext()) {
                        Zombie zombie = zombieIterator.next();
                        if (pea.getBoundsInParent().intersects(zombie.getBoundsInParent())) {
                            zombie.health--;
                            root.getChildren().remove(pea);
                            peaIterator.remove();
                            if (zombie.health <= 0) {
                                root.getChildren().remove(zombie);
                                zombieIterator.remove();
                            }
                            break;
                        }
                    }

                    // Remove pea if off screen
                    if (pea.getCenterX() > 800) {
                        root.getChildren().remove(pea);
                        peaIterator.remove();
                    }
                }

                // Move zombies
                Iterator<Zombie> zombieIterator = zombies.iterator();
                while (zombieIterator.hasNext()) {
                    Zombie zombie = zombieIterator.next();
                    zombie.move();

                    // Check if zombie reaches left (game over)
                    if (zombie.getX() < 0) {
                        stop();
                        System.out.println("GAME OVER! Zombie got through!");
                    }
                }
            }
        };
        gameLoop.start();

        stage.setTitle("Mini Plant vs Zombie - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


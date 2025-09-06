package chatgptRPG;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class RPGStarter extends Application {

    // Tile size
    final int TILE_SIZE = 32;
    final int MAP_WIDTH = 20;
    final int MAP_HEIGHT = 15;

    // Player position
    double playerX = 5 * TILE_SIZE;
    double playerY = 5 * TILE_SIZE;

    // NPC position
    double npcX = 10 * TILE_SIZE;
    double npcY = 8 * TILE_SIZE;

    boolean showDialogue = false;

    Set<KeyCode> pressedKeys = new HashSet<>();

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(MAP_WIDTH * TILE_SIZE, MAP_HEIGHT * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Load sprites (replace with your own)
        Image playerImg = new Image("https://i.imgur.com/1XWZtTI.png", TILE_SIZE, TILE_SIZE, false, false);
        Image npcImg = new Image("https://i.imgur.com/n3SxqlC.png", TILE_SIZE, TILE_SIZE, false, false);

        Scene scene = new Scene(new StackPane(canvas));
        scene.setOnKeyPressed(e -> pressedKeys.add(e.getCode()));
        scene.setOnKeyReleased(e -> pressedKeys.remove(e.getCode()));

        stage.setScene(scene);
        stage.setTitle("JavaFX RPG Starter");
        stage.show();

        // Game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render(gc, playerImg, npcImg);
            }
        };
        timer.start();
    }

    void update() {
        double speed = 2;

        if (pressedKeys.contains(KeyCode.W)) playerY -= speed;
        if (pressedKeys.contains(KeyCode.S)) playerY += speed;
        if (pressedKeys.contains(KeyCode.A)) playerX -= speed;
        if (pressedKeys.contains(KeyCode.D)) playerX += speed;

        // Check collision with NPC
        if (Math.abs(playerX - npcX) < TILE_SIZE && Math.abs(playerY - npcY) < TILE_SIZE) {
            showDialogue = true;
        } else {
            showDialogue = false;
        }
    }

    void render(GraphicsContext gc, Image playerImg, Image npcImg) {
        // Draw background
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, MAP_WIDTH * TILE_SIZE, MAP_HEIGHT * TILE_SIZE);

        // Draw NPC
        gc.drawImage(npcImg, npcX, npcY);

        // Draw Player
        gc.drawImage(playerImg, playerX, playerY);

        // Dialogue box
        if (showDialogue) {
            gc.setFill(Color.rgb(0, 0, 0, 0.7));
            gc.fillRect(20, MAP_HEIGHT * TILE_SIZE - 100, MAP_WIDTH * TILE_SIZE - 40, 80);

            gc.setFill(Color.WHITE);
            gc.setFont(Font.font(18));
            gc.fillText("NPC: Hello, traveler! Welcome to the village.", 40, MAP_HEIGHT * TILE_SIZE - 60);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

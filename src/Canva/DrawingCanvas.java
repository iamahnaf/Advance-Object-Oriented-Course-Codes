package Canva;

import javafx.scene.canvas.Canvas;

import java.io.IOException;
import java.io.ObjectOutputStream;


public class DrawingCanvas extends Canvas {
    private double lastX, lastY;
    private ObjectOutputStream out;  // Assuming this is set up for communication

    public DrawingCanvas(ObjectOutputStream out) {
        this.out = out;

        setOnMousePressed(e -> {
            lastX = e.getX();
            lastY = e.getY();
        });

        setOnMouseDragged(e -> {
            double currentX = e.getX();
            double currentY = e.getY();
            getGraphicsContext2D().strokeLine(lastX, lastY, currentX, currentY);
            lastX = currentX;
            lastY = currentY;

            // Send drawing data to server or client
            sendDrawingData(new DrawingData(lastX, lastY, currentX, currentY));
        });
    }

    // Define the sendDrawingData method
    private void sendDrawingData(DrawingData data) {
        try {
            if (out != null) {
                out.writeObject(data);  // Send drawing data through the output stream
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

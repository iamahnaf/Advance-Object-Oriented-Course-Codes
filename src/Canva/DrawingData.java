package Canva;

import java.io.Serializable;

public class DrawingData implements Serializable {
    private double startX, startY, endX, endY;

    public DrawingData(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    // Getters and setters
}

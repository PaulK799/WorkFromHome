package com.paul.learning.wfh.recursion.input;

import com.paul.learning.wfh.patterns.creational.prototype.Position;
import com.paul.learning.wfh.recursion.FloodFill;

/**
 * POJO class representing the Input needed to perform {@link FloodFill}.
 */
public class FloodFillInput {
    private int red;
    private int green;
    private int blue;
    private int originalColor;
    private int newColor;
    private int[][] image;
    private int iterations;
    private Position position;

    public FloodFillInput() {
        this.iterations = 0;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getOriginalColor() {
        return originalColor;
    }

    public void setOriginalColor(int originalColor) {
        this.originalColor = originalColor;
    }

    public int getNewColor() {
        return newColor;
    }

    public void setNewColor(int newColor) {
        this.newColor = newColor;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}

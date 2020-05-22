package es.uv.eu.mvc.model;

import java.awt.Color;

public class PaintModel {
    
    private Color defaultFigureOutlineColor = Color.BLACK;
    private Color defaultFigureBackgroundColor = Color.BLACK;
    private int defaultThickness = 10;
    private Color currentFigureOutlinecolor;
    private Color currentFigureBackgroundColor;
    private int currentThickness;
    private int drawnFiguresNumber = 0;
    private DrawingMode drawingMode = null;
    private Color backgroundColor = Color.WHITE;
    
    public static enum DrawingMode {
        DRAWING_RECTANGLES,
        DRAWING_TRIANGLES,
        DRAWING_CIRCLES,
        ERASER;
    }
    
    public PaintModel() {
        setCurrentToDefault();
    }

    public void setDefaultOutlineColor(Color defaultOutlineColor) {
        this.defaultFigureOutlineColor = defaultOutlineColor;
    }

    public void setDefaultBackgroundColor(Color defaultBackgroundColor) {
        this.defaultFigureBackgroundColor = defaultBackgroundColor;
    }

    public void setDefaultThickness(int defaultThickness) {
        this.defaultThickness = defaultThickness;
    }

    public void setCurrentOutlineColor(Color currentOutlinecolor) {
        this.currentFigureOutlinecolor = currentOutlinecolor;
    }

    public void setCurrentBackgroundColor(Color currentBackgroundColor) {
        this.currentFigureBackgroundColor = currentBackgroundColor;
    }

    public void setCurrentThickness(int currentThickness) {
        this.currentThickness = currentThickness;
    }

    public void setDrawingMode(DrawingMode drawingMode) {
        this.drawingMode = drawingMode;
    }

    public Color getDefaultOutlineColor() {
        return defaultFigureOutlineColor;
    }

    public Color getDefaultBackgroundColor() {
        return defaultFigureBackgroundColor;
    }

    public int getDefaultThickness() {
        return defaultThickness;
    }

    public Color getCurrentOutlineColor() {
        return currentFigureOutlinecolor;
    }

    public Color getCurrentBackgroundColor() {
        return currentFigureBackgroundColor;
    }

    public int getCurrentThickness() {
        return currentThickness;
    }

    public int getDrawnFiguresNumber() {
        return drawnFiguresNumber;
    }

    public DrawingMode getDrawingMode() {
        return drawingMode;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void incrementDrawnFigures() {
        drawnFiguresNumber++;
    }
    
    public final void setCurrentToDefault() {
        currentThickness = defaultThickness;
        currentFigureOutlinecolor = defaultFigureOutlineColor;
        currentFigureBackgroundColor = defaultFigureBackgroundColor;
    }
}
